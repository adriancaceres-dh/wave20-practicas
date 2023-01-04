package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostPromoCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostPromoListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
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
import org.springframework.http.ResponseEntity;
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

        List<PostResponseDto> posts = followedByuserId
                .stream()
                .map(postRepository::getPostsByUserId) // Get the List of Posts from each seller.
                .flatMap(List::stream) // Get a flat List with every Post
                .filter(post -> LocalDate.now().minusDays(Parameter.getInteger("NumberOfDays")).isBefore(post.getDate()))
                .map(post -> mapToPostResponseDto(post, id, false))
                .collect(Collectors.toList());

        return PostListResponseDto
                .builder()
                .userId(id)
                .posts(sortPostByDate(posts, order))
                .build();
    }

    @Override
    public boolean add(PostRequestDto postDto) {
        if (postDto == null || postDto.getUserId() == Parameter.getInteger("InvalidId")) {
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        } else {
            if (productService.alreadyExist(postDto.getProduct().getProductId()))
                throw new BadRequestException(Parameter.getString("EX_ExistingProduct"));

            if (!userService.alreadyExists(postDto.getUserId()))
                throw new BadRequestException(Parameter.getString("EX_InvalidUser"));

            ProductRequestDto productDto = postDto.getProduct();
            productService.add(productDto);
            postRepository.add(buildPost(postDto, productDto.getProductId()));
            //Se actualiza el usuario indicando que es seller en caso de que se trate de su primer posteo.
            userService.updateUser(postDto.getUserId());

            return true;
        }
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

    @Override
    public PostPromoCountResponseDto promoPostCountByUser(int userId) {
        userService.validateUserExistById(userId);
        User user = userService.getUserById(userId);
        int postWithPromoCount = (int) postRepository
                .getPostsByUserId(userId)
                .stream()
                .filter(post -> post.isHasPromo())
                .count();
        return new PostPromoCountResponseDto(user.getId(),user.getName(),postWithPromoCount);
    }

    @Override
    public PostListResponseDto promoPostListByUser(int userId){
        userService.validateUserExistById(userId);
        User user = userService.getUserById(userId);
        List<PostResponseDto> postResponses = postRepository
                .getPostsByUserId(userId)
                .stream()
                .filter(post -> post.isHasPromo())
                .map(post -> mapToPostResponseDto(post, userId, true))
                .collect(Collectors.toList());
        return PostListResponseDto
                .builder()
                .posts(postResponses)
                .userId(user.getId())
                .userName(user.getName())
                .build();
    }

    private PostResponseDto mapToPostResponseDto(Post post, int userId, boolean setPromo) {
        PostResponseDto.PostResponseDtoBuilder res = PostResponseDto
                .builder()
                .userId(userId)
                .postId(post.getId())
                .date(post.getDate())
                .product(productService.getProductById(post.getProductId()))
                .category(post.getCategory())
                .price(post.getPrice());
        PostResponseDto.PostResponseDtoBuilder withPromo = setPromo ?
                res.hasPromo(post.isHasPromo()).discount(post.getDiscount()) :
                res;
        return res.build();
    }
}
