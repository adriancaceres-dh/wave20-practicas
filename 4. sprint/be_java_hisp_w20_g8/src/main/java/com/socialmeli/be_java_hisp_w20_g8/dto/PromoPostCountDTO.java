package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PromoPostCountDTO {
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("promo_products_count")
    int promoProductsCount;
}
