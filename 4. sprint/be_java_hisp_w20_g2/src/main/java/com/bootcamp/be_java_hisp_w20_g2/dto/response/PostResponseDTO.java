package com.bootcamp.be_java_hisp_w20_g2.dto.response;

import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResponseDTO {
    private int userId;
    private List<PostDTO> posts;

    public PostResponseDTO(int userId) {
        this.userId = userId;
        posts = new ArrayList<>();
    }

    public void addPost(Post post, int userId) {
        posts.add(new PostDTO(userId, post));
    }

    @NoArgsConstructor @Getter @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    private class PostDTO {
        private int userId;
        private int postId;
        private LocalDate date;
        private ProductDTO product;
        private int category;
        private double price;

        public PostDTO(int userId, Post post) {
            this.userId = userId;
            postId = post.getId();
            date = post.getDate();
            product = new ProductDTO(post.getProduct());
            category = post.getCategory().getCode();
            price = post.getPrice();
        }
    }
}
