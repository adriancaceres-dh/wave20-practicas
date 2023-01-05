package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
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
            //Se actualiza el usuario indicando que es seller en caso de que se trate de su primer posteo.
            userService.updateUser(postDto.getUserId());
            PostResponseDto postResponseDto = mapper.map(postDto, PostResponseDto.class);
            postResponseDto.setPostId(post.getId());
            return postResponseDto;
        }
    }

    @Override
    public PostPromoResponseDto addPromo(PostPromoRequestDto postPromo) {

        if (postPromo == null || postPromo.getUserId() == Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        } else {
            if(!postPromo.isHasPromo())throw new BadRequestException(Parameter.getString("EX_NotHasPromo"));

            if (productService.alreadyExist(postPromo.getProduct().getProductId())) {
                throw new BadRequestException(Parameter.getString("EX_ExistingProduct"));
            }
            if (!userService.alreadyExists(postPromo.getUserId())) {

                throw new BadRequestException(Parameter.getString("EX_InvalidUser"));
            }

            ProductRequestDto productDto = postPromo.getProduct();
            productService.add(productDto);
            Post post = buildPostPromo(postPromo, productDto.getProductId());
            postRepository.add(post);
            userService.updateUser(postPromo.getUserId());
            PostPromoResponseDto postPromoResponseDto = mapper.map(postPromo, PostPromoResponseDto.class);
            postPromoResponseDto.setPostId(post.getId());
            return postPromoResponseDto;
        }

    }

    @Override
    public PostPromoListByUserResponseDto promoPostListByUser(int userId) {
        Set<PostPromoResponseDto> listPostPromoResponseDto =new HashSet<>();
        User userSeller = userService.getUserSeller(userId);
        List<Post> post = postRepository.getPostsByUserId(userSeller.getId());
        Set<Post> listPromoPost = post.stream().filter(x->x.isHasPromo())
                .collect(Collectors.toSet());
        for(Post p : listPromoPost){
            PostPromoResponseDto postPromoResponseDto = mapper.map(p, PostPromoResponseDto.class);
            postPromoResponseDto.setProduct(mapper.map( productService.getProductById(p.getProductId()), ProductResponseDto.class));
            listPostPromoResponseDto.add(postPromoResponseDto);
        }
        PostPromoListByUserResponseDto postPromoListByUserResponseDto = new PostPromoListByUserResponseDto();
        postPromoListByUserResponseDto.setUserId(userSeller.getId());
        postPromoListByUserResponseDto.setUserName(userSeller.getName());
        postPromoListByUserResponseDto.setPost(listPostPromoResponseDto);

        return postPromoListByUserResponseDto;

    }

    @Override
    public PostPromoCountResponseDto countPromoPost(int userId) {
        User userSeller = userService.getUserSeller(userId);
        List<Post> post = postRepository.getPostsByUserId(userSeller.getId());
        Long numberPost =  post.stream().filter(x-> x.isHasPromo()).count();
        PostPromoCountResponseDto postPromoCountResponseDto = new PostPromoCountResponseDto();
        postPromoCountResponseDto.setUserId(userSeller.getId());
        postPromoCountResponseDto.setUserName(userSeller.getName());
        postPromoCountResponseDto.setPromoProductsCount((numberPost.intValue()));

        return postPromoCountResponseDto;
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

    public Post buildPostPromo(PostPromoRequestDto postDto, int productId) {
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
}
