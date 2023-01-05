package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoPostBySellerDTO {
    int user_id;
    String user_name;
    long promo_products_count;
}
