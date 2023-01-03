package com.bootcamp.be_java_hisp_w20_g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DiscountPostCountResponseDTO {
    private int user_id ;
    private String user_name;
    private int promo_products_count;
}
