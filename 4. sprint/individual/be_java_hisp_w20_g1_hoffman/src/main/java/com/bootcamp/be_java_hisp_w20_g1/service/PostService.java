package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.interfaces.BasePostDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper mapper;

    public List<PostResponseDto> sortPostByDate(List<PostResponseDto> posts, String order) {
        if (order.equalsIgnoreCase(Parameter.getString("DateOrder"))) {
            posts.sort(Comparator.comparing(PostResponseDto::getDate));
        } else {
            posts.sort(Comparator.comparing(PostResponseDto::getDate).reversed());
        }
        return posts;
    }

    public PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order) {
        userService.validateUserExistById(id);
        Set<Integer> followedByuserId = userService.getUserFollowed(id);

        List<PostResponseDto> posts = followedByuserId.stream() // Stream every seller followed by parameter id
                .map(postRepository::getPostsByUserId) // Get the List of Posts from each seller.
                .flatMap(List::stream) // Get a flat List with every Post
                .filter(post -> LocalDate.now().minusDays(Parameter.getInteger("NumberOfDays")).isBefore(post.getDate()))
                .map(post -> PostResponseDto.builder().userId(id) // Only map Posts from the last 2 weeks.
                        .postId(post.getId())
                        .date(post.getDate())
                        .product(productService.getProductById(post.getProductId()))
                        .category(post.getCategory())
                        .price(post.getPrice())
                        .build()).collect(Collectors.toList());

        return new PostListResponseDto(id, sortPostByDate(posts, order));
    }


    @Override
    public PostResponseDto add(PostRequestDto postDto) {
        if (postDto == null || postDto.getUserId() == Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        } else {
            if (productService.alreadyExist(postDto.getProduct().getProductId())) {
                throw new BadRequestException(Parameter.getString("EX_ExistingProduct"));
            }
            if (!userService.alreadyExists(postDto.getUserId())) {

                throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
            }
            ProductRequestDto productDto = postDto.getProduct();
            productService.add(productDto);
            Post post = buildPost(postDto, productDto.getProductId());
            postRepository.add(post);
            //The user is updated indicating that he is a seller in case it is his first post.
            userService.updateUser(postDto.getUserId());
            PostResponseDto postResponseDto = mapper.map(postDto, PostResponseDto.class);
            postResponseDto.setPostId(post.getId());
            return postResponseDto;
        }
    }

    public Post buildPost(PostRequestDto postDto, int productId) {
        Post post = mapper.map(postDto, Post.class);
        post.setProductId(productId);
        //If it is the first post made by the user, id is set to 1, otherwise, the number is set as id
        //immediately after the last post made.
        if (postRepository.getPosts().isEmpty()) {
            post.setId(Parameter.getInteger("InitialId"));
        } else {
            Optional<Integer> lastId = postRepository.getPosts().stream().map(p -> p.getId()).max(Comparator.comparing(Integer::valueOf));
            if (lastId.isPresent()) {
                Integer aux = lastId.get();
                post.setId(++aux);
            }
        }
        return post;
    }

    @Override
    public PromoPostResponseDto addPromoPost(PromoPostRequestDto promoPost) {
        Optional<Post> post = postRepository.getPosts().stream().
                filter(p -> p.getProductId() == promoPost.getProduct().getProductId()).findAny();
        double newPrice = promoPost.getPrice() - promoPost.getPrice() * promoPost.getDiscount();
        if (post.isPresent()) {
            if (post.get().getUserId() != promoPost.getUserId()) {
                throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
            }
            PromoPostResponseDto finalPost = modifyPost(promoPost);
            finalPost.setPrice(newPrice);
            return finalPost;
        } else {
            return createPromoPost(promoPost, newPrice);

        }
    }

    private PromoPostResponseDto createPromoPost(PromoPostRequestDto promoPost, double newPrice) {
        PostResponseDto postResponse = add(mapper.map(promoPost, PostRequestDto.class));
        Optional<Post> savedPost = postRepository.getPosts().stream().
                filter(p -> p.getId() == postResponse.getPostId()).findAny();
        //It should always be present because I just created it.
        if (savedPost.isPresent()) {
            savedPost.get().setHasPromo(true);
            savedPost.get().setDiscount(promoPost.getDiscount());
            savedPost.get().setPrice(newPrice);
        }
        PromoPostResponseDto promoPostResponseDto =  mapper.map(savedPost, PromoPostResponseDto.class);;
        ProductResponseDto productDto = productService.getProductById(promoPost.getProduct().getProductId());
        promoPostResponseDto.setProduct(productDto);
        return promoPostResponseDto;
    }

    @Override
    public List<BasePostDto> getSellerPromoProducts(int userId, boolean list, Optional<String> order) {
        UserResponseDto user = userService.getUserDtoById(userId);
        if (user == null || !userService.isSeller(userId)) {
            throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
        }
        BasePostDto promoPostCountDto = new PromoPostCountDto();
        List<Post> posts = postRepository.getPosts().stream().filter(p -> p.getUserId() == userId).
                filter(p -> p.isHasPromo()).collect(Collectors.toList());
        if (!list) {
            ((PromoPostCountDto) promoPostCountDto).setUserId(userId);
            ((PromoPostCountDto) promoPostCountDto).setUserName(user.getUserName());
            ((PromoPostCountDto) promoPostCountDto).setPromoProductsCount(posts.size());
            ArrayList<BasePostDto> fakeList = new ArrayList<>();
            fakeList.add(promoPostCountDto);
            return fakeList;
        } else {
            return getPostsDtoFromSeller(posts, order);
        }

    }

    private List<BasePostDto> getPostsDtoFromSeller(List<Post> posts, Optional<String> order) {
        List<PromoPostResponseDto> postsDto = posts.stream().map(p -> mapper.map(p, PromoPostResponseDto.class)).collect(Collectors.toList());
        int aux = 0;
        for (Post post : posts) {
            ProductResponseDto product;
            try {
                product = productService.getProductById(post.getProductId());
            } catch (NotFoundException e) { //This shouldn't happen since all posts have a product associated with them.
                throw e;
            }
            postsDto.get(aux).setProduct(product);
            aux++;
        }
        postsDto.sort(compareProductFromName());
        if (order.isPresent() && order.get().equals("desc"))  postsDto.sort(compareProductFromName().reversed());
        return postsDto.stream().map(p -> (BasePostDto) p).collect(Collectors.toList());
    }

    public Comparator<PromoPostResponseDto> compareProductFromName() {
        Comparator<PromoPostResponseDto> postComparator = (p1, p2) -> {
            int compName = p1.getProduct().getProductName().compareTo(p2.getProduct().getProductName());
            if (compName != 0) {
                return compName;
            }
            return compName;
        };
        return postComparator;
    }

    @Override
    public PromoPostResponseDto modifyPost(PromoPostRequestDto postDto) {
        Optional<Post> post = postRepository.getPosts().stream().
                filter(p -> p.getProductId() == postDto.getProduct().getProductId()).findAny();
        if (!post.isPresent() || postDto.getProduct().getProductId() != post.get().getProductId())
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        if (postDto.getUserId() != post.get().getUserId())  throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
        if (post.get().equals(mapper.map(postDto, Post.class))) return mapper.map(post, PromoPostResponseDto.class);
        //Changes in the post.
        post.get().setPrice(postDto.getPrice());
        post.get().setDiscount(postDto.getDiscount());
        post.get().setHasPromo(postDto.isHasPromo());
        post.get().setCategory(postDto.getCategory());
        post.get().setDate(postDto.getDate());
        //Changes in the product associated with the post.
        PromoPostResponseDto postResponse = mapper.map(post, PromoPostResponseDto.class);
        postResponse.setProduct(modifyProduct(post.get(), postDto));
        return postResponse;
    }

    private ProductResponseDto modifyProduct(Post post, PromoPostRequestDto postDto) {
        ProductRequestDto productDto = postDto.getProduct();
        ProductResponseDto product;
        try{
            product = productService.getProductById(post.getProductId());
        } catch (NotFoundException e) { //This shouldn't happen since all posts have a product associated with them.
            throw e;
        }
        if (productDto.equals(mapper.map(product, ProductRequestDto.class))) return product;
        return productService.modifyProduct(productDto, product);
    }

}



