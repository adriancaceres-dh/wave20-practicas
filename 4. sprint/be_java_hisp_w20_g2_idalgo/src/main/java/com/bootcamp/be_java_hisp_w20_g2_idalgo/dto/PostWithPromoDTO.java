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
public class PostWithPromoDTO {
    @JsonUnwrapped
    private PostDTO post;
    private boolean hasPromo;
    private double discount;

    public PostWithPromoDTO(int userId, LocalDate date, ProductDTO product, int category, double price, boolean hasPromo, double discount) {
        this.post = new PostDTO(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
