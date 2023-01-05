package com.bootcamp.be_java_hisp_w20_g2_podio.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostWithIdDTO extends PostDTO {
    private int postId;

    public PostWithIdDTO(int userId, LocalDate date, ProductDTO product, int category, double price, boolean hasPromo, double discount, int postId) {
        super(userId, date, product, category, price, hasPromo, discount);
        this.postId = postId;
    }
}