package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

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
            if (LocalDate.now().minusDays(14).isBefore(post.getCreationDate())) {
                posts.add(PostResponseDto.builder()
                        .userId(id)
                        .postId(post.getId())
                        .date(post.getCreationDate())
                        .product(productService.getProductById(post.getProductId()))
                        .category(post.getCategoryId())
                        .price(post.getPrice())
                        .build()
                );
            }
        }
        return posts;
    }
}
