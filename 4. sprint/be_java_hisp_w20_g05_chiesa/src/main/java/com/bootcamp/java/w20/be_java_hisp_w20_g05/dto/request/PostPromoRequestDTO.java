package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostPromoRequestDTO extends PostRequestDTO {
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public PostPromoRequestDTO(int userId, LocalDate date, ProductRequestDTO product, int category, double price, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}