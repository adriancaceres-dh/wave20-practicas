package com.bootcamp.be_java_hisp_w20_g2_espindola.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoDTO extends PostWithIdDTO{

    private boolean hasPromo;

    private double discount;

    public PostPromoDTO(int userId, LocalDate date, ProductDTO product, int category, double price, int postId, boolean hasPromo, double discount) {
        super(userId, date, product, category, price, postId);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
