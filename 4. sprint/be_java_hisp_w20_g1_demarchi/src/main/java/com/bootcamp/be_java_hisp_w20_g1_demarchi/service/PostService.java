package com.bootcamp.be_java_hisp_w20_g1_demarchi.service;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Product;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.User;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.pojo.PostFilter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces.IUserService;
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
                        .product(mapper.map(productService.getProductById(post.getProductId()), ProductResponseDto.class))
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
            validateUserExistsOrEnd(postDto.getUserId());
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
    }

    @Override
    public PostPromoResponseDto add(PostPromoRequestDto postDto) {
        if (postDto.getUserId() == Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        }
        validateUserExistsOrEnd(postDto.getUserId());
        validateProductsAreExactlyEqualOrEnd(postDto);

        ProductRequestDto productRequestDto = postDto.getProduct();
        productService.add((productRequestDto));
        Post newPost = buildPromoPost(postDto);
        postRepository.add(newPost);
        userService.updateUser(postDto.getUserId());

        PostPromoResponseDto postPromoResponseDto = mapper.map(postDto, PostPromoResponseDto.class);
        postPromoResponseDto.setPostId(newPost.getId());
        postPromoResponseDto.setPriceWithDiscount(getPriceWithDiscount(newPost.getPrice(), newPost.getDiscount()));

        return postPromoResponseDto;
    }

    private void validateProductsAreExactlyEqualOrEnd(PostPromoRequestDto postDto) {
        if (productService.alreadyExist(postDto.getProduct().getProductId())) {
            Product oldProduct = productService.getProductById(postDto.getProduct().getProductId());
            Product currentProduct = mapper.map(postDto.getProduct(), Product.class);
            if (!oldProduct.equals(currentProduct)) {
                throw new BadRequestException(Parameter.getString("EX_WrongProductValues"));
            }
        }
    }

    @Override
    public PostPromoListCountResponseDto getAmountOfPostsOnPromotion(int id) {
        User userFound = getUserIfValid(id);
        return PostPromoListCountResponseDto.builder()
                .userId(id)
                .userName(userFound.getName())
                .promoProductsCount(postRepository.getPostOnPromotionByUserId(id).size())
                .build();
    }

    private User getUserIfValid(int id) {
        validateUserExistsOrEnd(id);
        if (!userService.isSeller(id)) {
            throw new BadRequestException(Parameter.getString("EX_NotASeller"));
        }
        return userService.getUserById(id);
    }

    private void validateUserExistsOrEnd(int id) {
        if (!userService.alreadyExists(id)) {
            throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
        }
    }

    @Override
    public SellerWithProductsOnPromoListResponseDto getProductsOnPromotionByUser(
            int id,
            PostFilter postFilter) {
        User userFound = getUserIfValid(id);

        List<PostPromoResponseDto> postsOnPromotionDto = postRepository.getPostOnPromotionByUserId(id)
                .stream()
                .map(p -> {
                            PostPromoResponseDto post = mapper.map(p, PostPromoResponseDto.class);
                            post.setProduct(mapper.map(productService.getProductById(p.getProductId()), ProductRequestDto.class));
                            post.setPriceWithDiscount(getPriceWithDiscount(p.getPrice(), p.getDiscount()));
                            return post;
                        }
                )
                .filter(postFilter.getMaxPrice() > 0 ? p -> p.getPriceWithDiscount() <= postFilter.getMaxPrice(): p -> true)
                .filter(postFilter.getMinPrice() > 0 ? p -> p.getPriceWithDiscount() >= postFilter.getMinPrice(): p -> true)
                .filter(postFilter.getCategory() > 0 ? p -> p.getCategory() == postFilter.getCategory(): p -> true)
                .filter(postFilter.getMinDiscount() > 0.0 ? p -> p.getDiscount() >= postFilter.getMinDiscount(): p -> true)
                .collect(Collectors.toList());

        return new SellerWithProductsOnPromoListResponseDto(
                userFound.getId(),
                userFound.getName(),
                postsOnPromotionDto
        );
    }

    private double getPriceWithDiscount(double postPrice, double discount) {
        return postPrice * (1 - discount);
    }

    private Post buildPromoPost(PostPromoRequestDto postPromoRequestDto) {
        Post newPromoPost = mapper.map(postPromoRequestDto, Post.class);
        return getPostAfterAddingId(newPromoPost);
    }

    public Post buildPost(PostRequestDto postDto, int productId) {
        Post post = mapper.map(postDto, Post.class);
        post.setProductId(productId);
        return getPostAfterAddingId(post);
    }

    private Post getPostAfterAddingId(Post newPost) {
        if (postRepository.getPosts().isEmpty()) {
            newPost.setId(Parameter.getInteger("InitialId"));
        } else {
            Integer lastId = postRepository.getPosts()
                    .stream()
                    .map(Post::getId)
                    .max(Comparator.comparing(Integer::valueOf))
                    .get();
            newPost.setId(lastId + 1);
        }
        return newPost;
    }
}
