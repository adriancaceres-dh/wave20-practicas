package com.socialMeli.be_java_hisp_w20_g03.utils;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.request.ProductDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostUtils {

    static ModelMapper mapper = new ModelMapper();

    public static List<Post> getLatestPosts(){
        LocalDate currentDate = LocalDate.now();
        List<Post> posts = new ArrayList<>();
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
                .date(currentDate.minusDays(1))
                .build();
        Post post2 = Post.builder()
                .postId(2)
                .userId(234)
                .category(1)
                .price(1050)
                .product(product1)
                .date(currentDate.minusDays(3))
                .build();
        Post post3 = Post.builder()
                .postId(3)
                .userId(234)
                .category(1)
                .price(1400)
                .product(product2)
                .date(currentDate.minusDays(6))
                .build();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        return posts;
    }

    public static List<PostDTO> postDTOConverter(List<Post> posts){
        List<PostDTO> postsDTO = new ArrayList<>();
        posts.stream().forEach(post -> postsDTO.add(mapper.map(post,PostDTO.class)));
        return postsDTO;
    }

    public static List<Post> getAscendingDatePosts() {
        LocalDate currentDate = LocalDate.now();
        List<Post> posts = new ArrayList<>();
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
                .date(currentDate.minusDays(6))
                .build();
        Post post2 = Post.builder()
                .postId(2)
                .userId(234)
                .category(1)
                .price(1050)
                .product(product1)
                .date(currentDate.minusDays(3))
                .build();
        Post post3 = Post.builder()
                .postId(3)
                .userId(234)
                .category(1)
                .price(1400)
                .product(product2)
                .date(currentDate.minusDays(1))
                .build();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        return posts;
    }

    public static PostDTO createPost (int userId){
        LocalDate currentDate = LocalDate.now();
        PostDTO post = PostDTO.builder()
                .postId(500)
                .userId(userId)
                .date(currentDate.minusDays(1))
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Silla Gamer")
                        .type("Gamer")
                        .brand("Racer")
                        .color("Red and Black")
                        .notes("Special Edition")
                        .build()
                )
                .category(100)
                .price(1500.50)
                .build();

        return post;
    }
}
