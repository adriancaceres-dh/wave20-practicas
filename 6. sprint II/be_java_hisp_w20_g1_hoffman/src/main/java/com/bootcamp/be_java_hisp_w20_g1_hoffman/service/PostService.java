package com.bootcamp.be_java_hisp_w20_g1_hoffman.service;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {


    private IPostRepository postRepository;


    private IProductService productService;


    private IUserService userService;


    private ModelMapper mapper;

    public PostService(IPostRepository postRepository, ProductService productService, UserService userService, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.productService = productService;
        this.userService = userService;
        this.mapper = mapper;
    }

    public List<PostResponseDto> sortPostByDate(List<PostResponseDto> posts, String order) {
        List<String> orders = Arrays.asList(Parameter.getString("DateAsc"), Parameter.getString("DateDesc"));

        if (!orders.contains(order)) {
            throw new InvalidQueryParamValueException(Parameter.getString("EX_InvalidQueryParamValue"));
        }

        if (order.equalsIgnoreCase(Parameter.getString("DateDesc"))) {
            posts.sort(Comparator.comparing(PostResponseDto::getDate));
        } else {
            posts.sort(Comparator.comparing(PostResponseDto::getDate).reversed());
        }

        return posts;
    }

    public PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order) {
        userService.validateUserExistById(id);
        Set<Integer> followedByuserId = userService.getUserFollowed(id);

        List<PostResponseDto> posts = followedByuserId.stream()
                .map(postRepository::getPostsByUserId) // Obtiene la lista de Posts de cada vendedor.
                .flatMap(List::stream) // Concatena lista de publicaciones de todos los vendedores a una única lista.
                .filter(post -> LocalDate.now().minusDays(Parameter.getInteger("NumberOfDays")).isBefore(post.getDate()))
                .map(post -> PostResponseDto.builder().userId(post.getUserId()) // Solo mapea los posts de los últimos 14 días.
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
            userService.updateUser(postDto.getUserId(), post.getId());
            PostResponseDto postResponseDto = mapper.map(postDto, PostResponseDto.class);
            postResponseDto.setPostId(post.getId());
            return postResponseDto;
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
}
