package com.socialMeli.be_java_hisp_w20_g03.repository;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.socialMeli.be_java_hisp_w20_g03.model.Post;

import static java.time.temporal.ChronoUnit.DAYS;

@Repository
public class PostRepository implements IPostRepository {

    private List<Post> postsList;

    public PostRepository() {
        postsList = new ArrayList<>();
        Product product1 = Product.builder()
                .productId(1)
                .productName("Silla Gamer")
                .type("Gamer")
                .brand("Racer")
                .color("Red & Black")
                .notes("Special Edition")
                .build();

        Product product2 = Product.builder()
                .productId(2)
                .productName("Headset RGB Inalámbrico")
                .type("Gamer")
                .brand("Racer")
                .color("Green with RGB")
                .notes("Sin Batería")
                .build();

        Post post1 = Post.builder()
                .postId(1)
                .userId(234)
                .category(1)
                .price(1000)
                .product(product1)
                .date(LocalDate.parse("2023-01-01"))
                .build();
        Post post2 = Post.builder()
                .postId(2)
                .userId(234)
                .category(1)
                .price(1050)
                .product(product1)
                .date(LocalDate.parse("2022-12-30"))
                .build();
        Post post3 = Post.builder()
                .postId(3)
                .userId(123)
                .category(2)
                .price(1500)
                .product(product2)
                .date(LocalDate.parse("2023-01-03"))
                .build();
        Post post4 = Post.builder()
                .postId(4)
                .userId(6932)
                .category(1)
                .price(1400)
                .product(product2)
                .date(LocalDate.parse("2023-01-01"))
                .build();
        Post post5 = Post.builder()
                .postId(5)
                .userId(234)
                .category(2)
                .price(990)
                .product(product2)
                .date(LocalDate.parse("2023-01-02"))
                .build();

        postsList.add(post1);
        postsList.add(post2);
        postsList.add(post3);
        postsList.add(post4);
        postsList.add(post5);
    }

    public boolean addPost(Post post) {
        postsList.add(post);
        return true;
    }

    public List<Post> getPosts() {
        return this.postsList;
    }

    public List<Post> getPostsByUserId(int userId) {
        LocalDate dateNow = LocalDate.now();
        return this.postsList.stream().filter(post -> post.getUserId() == userId)
                .filter(post -> DAYS.between(post.getDate(), dateNow) <= 15)
                .collect(Collectors.toList());
    }

}
