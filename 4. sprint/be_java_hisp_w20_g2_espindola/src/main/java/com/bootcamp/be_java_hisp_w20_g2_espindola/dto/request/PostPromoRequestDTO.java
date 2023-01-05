package com.bootcamp.be_java_hisp_w20_g2_espindola.dto.request;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.ProductDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoRequestDTO extends PostDTO {
    private boolean hasPromo;

    private double discount;

    public PostPromoRequestDTO(int userId, LocalDate date, ProductDTO product, int category, double price, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
