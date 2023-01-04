package com.socialMeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDiscountCountDto {
        @JsonProperty("user_id")
        private int userId;
        @JsonProperty("user_name")
        private String userName;
        @JsonProperty("promo_products_count")
        private int promoProductsCount;
}
