package com.bootcamp.be_java_hisp_w20_ramosruiz.service;

import com.bootcamp.be_java_hisp_w20_ramosruiz.Parameter;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PromoPostListResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PromoPostCountResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_ramosruiz.model.Post;
import com.bootcamp.be_java_hisp_w20_ramosruiz.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_ramosruiz.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_ramosruiz.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_ramosruiz.service.interfaces.IUserService;
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
        validatePost(postDto);

        if (productService.alreadyExist(postDto.getProduct().getProductId())) {
            throw new BadRequestException(Parameter.getString("EX_ExistingProduct"));
        }
        if (!userService.alreadyExists(postDto.getUserId())) {
            throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
        }

        return registerProductAndPost(postDto);
    }

    public PostResponseDto addPromo(PromoPostRequestDto postDto) {
        userService.validateUserExistById(postDto.getUserId());
        validatePost(postDto);
        validatePromo(postDto);

        int productId = postDto.getProduct().getProductId();
        if (productService.alreadyExist(productId)) {
            validatePostUpdate(postDto);
            return updatePromo(postDto);
        }

        return registerProductAndPost(postDto);
    }

    private PostResponseDto registerProductAndPost(PostRequestDto postDto) {
        ProductRequestDto productDto = postDto.getProduct();
        productService.add(productDto);
        Post post = buildPost(postDto, productDto.getProductId());
        postRepository.add(post);
        //Se actualiza el usuario indicando que es seller en caso de que se trate de su primer posteo.
        userService.updateUser(postDto.getUserId());
        PostResponseDto postResponseDto = mapper.map(postDto, PostResponseDto.class);
        postResponseDto.setPostId(post.getId());
        return postResponseDto;
    }

    public Post buildPost(PostRequestDto postDto, int productId) {
        Post post = mapper.map(postDto, Post.class);
        post.setProductId(productId);
        //Si se trata del primer posteo que realiza el usuario se le setea id 1, de lo contrario, se coloca como id el número
        //inmediatamente posterior al del último posteo realizado.
        if (postRepository.getPosts().isEmpty()) {
            post.setId(Parameter.getInteger("InitialId"));
        } else {
            Optional<Integer> lastId = postRepository.getPosts().stream()
                    .map(Post::getId).max(Comparator.comparing(Integer::valueOf));
            if (lastId.isPresent()) {
                Integer aux = lastId.get();
                post.setId(++aux);
            }
        }
        return post;
    }

    private PostResponseDto updatePromo(PromoPostRequestDto postDto) {
        Post existingPost = postRepository.getPostByProductId(postDto.getProduct().getProductId());

        Post post = mapper.map(postDto, Post.class);
        post.setId(existingPost.getId());
        postRepository.update(post);
        PostResponseDto postResponseDto = mapper.map(postDto, PostResponseDto.class);
        postResponseDto.setPostId(existingPost.getId());

        return postResponseDto;
    }

    private boolean validatePost(PostRequestDto postDto) {
        if (postDto == null || postDto.getUserId() <= Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        }
        return true;
    }

    private boolean validatePostUpdate(PromoPostRequestDto postDto) {
        Post existingPost = postRepository.getPostByProductId(postDto.getProduct().getProductId());
        boolean isOwnPost = existingPost.getUserId() == postDto.getUserId();

        if (!productService.isValidProductUpdate(postDto.getProduct()) || !isOwnPost)
            throw new BadRequestException(Parameter.getString("EX_ExistingProduct"));

        boolean isValidDate = existingPost.getDate().isBefore(postDto.getDate());
        boolean isValidCategory = existingPost.getCategory() == postDto.getCategory();
        boolean isValidDiscount = existingPost.getDiscount() != postDto.getDiscount();

        if (!(isValidDate && isValidCategory && isValidDiscount)) {
        throw new BadRequestException(Parameter.getString("EX_InvalidPostUpdate"));
        }
        
        return true;
    }

    private boolean validatePromo(PromoPostRequestDto postDto) {
        boolean isValidDiscount =  postDto.getDiscount() > 0.0 && postDto.getDiscount() < 1.0;
        if(!(postDto.getHasPromo() && isValidDiscount)) {
            throw new BadRequestException(Parameter.getString("EX_InvalidPromoDiscount"));
        }
        return true;
    }

    public PromoPostCountResponseDto countPromoPost(int userId) {
        userService.validateUserExistById(userId);
        userService.validateUserIsSellerById(userId);

        int promoPostCount = (int) postRepository.getPostsByUserId(userId).stream()
                .filter(Post::isHasPromo).count();
        PromoPostCountResponseDto responseDto = new PromoPostCountResponseDto(promoPostCount);
        responseDto.setUserId(userId);
        responseDto.setUserName(userService.getUserName(userId));

        return responseDto;
    }

    @Override
    public PromoPostListResponseDto listPromoPostByUserId(int userId, String order) {
        userService.validateUserExistById(userId);
        userService.validateUserIsSellerById(userId);

        List<PostResponseDto> promoPostList = postRepository.getPostsByUserId(userId).stream()
                .filter(Post::isHasPromo)
                .map(post -> PostResponseDto.builder()
                        .userId(userId)
                        .postId(post.getId())
                        .date(post.getDate())
                        .product(productService.getProductById(post.getProductId()))
                        .category(post.getCategory())
                        .price(post.getPrice())
                        .hasPromo(post.isHasPromo())
                        .discount(post.getDiscount())
                        .build()).collect(Collectors.toList());

        PromoPostListResponseDto responseDto = new PromoPostListResponseDto();
        responseDto.setUserId(userId);
        responseDto.setPosts(sortPostByDate(promoPostList, order));
        responseDto.setUserName(userService.getUserName(userId));

        return responseDto;
    }
}
