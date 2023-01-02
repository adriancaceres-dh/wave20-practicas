package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.BadRequestException;
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

    private final int initialId = 1;

    public List<PostResponseDto> sortPostByDate(List<PostResponseDto> posts, String order) {
        if (Objects.equals(order, "date_asc")) {
            posts.sort(Comparator.comparing(PostResponseDto::getDate));
        } else {
            posts.sort(Comparator.comparing(PostResponseDto::getDate).reversed());
        }
        return posts;
    }

    public PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order) {
        List<Integer> followedByuserId = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<PostResponseDto> posts = new ArrayList<>();

        for (Integer followed : followedByuserId) {
            posts.addAll(lastTwoWeeksPostsFromUserId(followed));
        }

        return new PostListResponseDto(id, sortPostByDate(posts, order));
    }

    @Override
    public List<PostResponseDto> lastTwoWeeksPostsFromUserId(int id) {
        List<PostResponseDto> posts = new ArrayList<>();
        for (Post post : postRepository.getPostsByUserId(id)) {
            if (LocalDate.now().minusDays(14).isBefore(post.getDate())) {
                posts.add(PostResponseDto.builder()
                        .userId(id)
                        .postId(post.getId())
                        .date(post.getDate())
                        .product(productService.getProductById(post.getProductId()))
                        .category(post.getCategory())
                        .price(post.getPrice())
                        .build()
                );
            }
        }
        return posts;
    }

    @Override
    public boolean add(PostRequestDto postDto) {
        if (postDto == null || postDto.getUserId()== 0) {
            throw new BadRequestException("Request body inválido");
        } else {
            if (!productService.alreadyExist(postDto.getProduct().getProductId()) &&
                    userService.alreadyExists(postDto.getUserId())) {

                ProductRequestDto productDto = postDto.getProduct();
                productService.add(productDto);
                postRepository.add(convertPost(postDto, productDto.getProductId()));
                userService.updateUser(postDto.getUserId());
                
                return true;
            } else {
                throw new BadRequestException("El producto ya existe");
            }
        }
    }

    public Post convertPost(PostRequestDto postDto, int productId) {
        Post post = mapper.map(postDto, Post.class);
        post.setProductId(productId);
        if (postRepository.getPosts().isEmpty()) {
            post.setId(initialId);
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
