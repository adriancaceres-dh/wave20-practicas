package com.bootcamp.be_java_hisp_w20_g2_idalgo.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostWithIdDTO {
    @JsonUnwrapped
    private PostDTO post;
    private int postId;

    public PostWithIdDTO(int userId, LocalDate date, ProductDTO product, int category, double price, int postId) {
        this.post = new PostDTO(userId, date, product, category, price);
        this.postId = postId;
    }
}