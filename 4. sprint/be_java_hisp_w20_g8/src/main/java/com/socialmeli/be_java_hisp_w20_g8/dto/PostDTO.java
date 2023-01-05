package com.socialmeli.be_java_hisp_w20_g8.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonPropertyOrder(value = {"user_id", "post_id", "date", "product", "category", "price"})
public class PostDTO {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;

    public PostDTO(Post post, ProductDTO productDTO) {
        this.user_id = post.getUser_id();
        this.post_id = post.getId() != null? post.getId() : 0;
        this.date = post.getDate();
        this.product = productDTO;
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
