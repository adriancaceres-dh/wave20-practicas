package com.bootcamp.be_java_hisp_w20_g1_berthet.service;

import com.bootcamp.be_java_hisp_w20_g1_berthet.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostPromoCounResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostPromoListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1_berthet.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_berthet.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces.IUserService;
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

    public PostPromoListResponseDto getPromoPosts(int id){
        userService.validateUserExistById(id);

        List<PostResponseDto> promoPostsOfUser = getPromoPostsByUserId(id).stream()
                .map(post -> PostResponseDto.builder().userId(id) // Only map Posts from the last 2 weeks.
                    .postId(post.getId())
                    .date(post.getDate())
                    .product(productService.getProductById(post.getProductId()))
                    .category(post.getCategory())
                    .price(post.getPrice())
                    .hasPromo(post.isHasPromo())
                    .discount(post.getDiscount())
                    .build())
                .collect(Collectors.toList());

        return new PostPromoListResponseDto(id, userService.getUsername(id), promoPostsOfUser);
    }

    public boolean productAlreadyExist(int productId){
        return productService.alreadyExist(productId);
    }

    @Override
    public boolean add(PostRequestDto postDto) {

        if (postDto == null || postDto.getUserId() == Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));

        }

        if (productAlreadyExist(postDto.getProduct().getProductId())) {
            throw new BadRequestException(Parameter.getString("EX_ExistingProduct"));
        }

        userService.validateUserExistById(postDto.getUserId());
        buildPostWithProduct(postDto);

        return true;
    }


    public Post buildPostWithProduct(PostRequestDto postDto){
        // build post with product
        ProductRequestDto productDto = postDto.getProduct();
        productService.add(productDto);
        //Se actualiza el usuario indicando que es seller en caso de que se trate de su primer posteo.
        userService.updateUser(postDto.getUserId());
        return postRepository.add(buildPost(postDto, productDto.getProductId()));
    }
    public Post buildPost(PostRequestDto postDto, int productId) {
        Post post = mapper.map(postDto, Post.class);
        post.setProductId(productId);
        //Si se trata del primer posteo que realiza el usuario se le setea id 1, de lo contrario, se coloca como id el número
        //inmediatamente posterior al del último posteo realizado.
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

    public PromoPostRequestDto addPromoPost(PromoPostRequestDto postDto){

        int productId = postDto.getProduct().getProductId();

        if (postDto == null || postDto.getUserId() == Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        }


        userService.validateUserExistById(postDto.getUserId());

        // if a product exist with same ID in a request, the promo post request product must match that product
        if (productAlreadyExist(productId)) {
            validateIfProductPostIsOfSameUser(postDto);
            validateProductMatchWithExistingProduct(postDto.getProduct());
        }
        if (promoWasAlreadyMade(postDto)) throw new BadRequestException(Parameter.getString("EX_PromoAlreadyExist"));

        buildPostWithProduct(postDto);
        return postDto;
        }

    private boolean validateIfProductPostIsOfSameUser(PromoPostRequestDto productRequest) {
        if ( postRepository.getPostsByUserId(productRequest.getUserId()).stream()
                .anyMatch(p -> p.getProductId() == productRequest.getProduct().getProductId())){
            return true;
        }

        throw new BadRequestException(Parameter.getString("EX_InvalidUserIdToPostPromo"));
    }

    public boolean promoWasAlreadyMade(PromoPostRequestDto promoPostRequestDto) {
        //check if already exist a promo with same userId, productId, Date and discount
        return(getPromoPostsByUserId(promoPostRequestDto.getUserId()).stream()
                .anyMatch(p -> p.getProductId() == promoPostRequestDto.getProduct().getProductId()
                        && p.getPrice() == promoPostRequestDto.getPrice()
                        && p.getDiscount() == promoPostRequestDto.getDiscount()));
    }

    public boolean validateProductMatchWithExistingProduct(ProductRequestDto product){
        if (!productService.matchWithExistingProduct(product)) {
            throw new BadRequestException(Parameter.getString("EX_ProductDoesntMatchId"));
        }
        return true;
    }


    public List<Post> getPromoPostsByUserId(int userId){
        return postRepository.getPostsByUserId(userId).stream().filter(Post::isHasPromo).collect(Collectors.toList());
    }


    public PostPromoCounResponseDto countPromoPosts(int userId){
        userService.validateUserExistById(userId);
        List<Post> promoPosts = getPromoPostsByUserId(userId);
        return new PostPromoCounResponseDto(userId, userService.getUsername(userId),promoPosts.size());
    }


}
