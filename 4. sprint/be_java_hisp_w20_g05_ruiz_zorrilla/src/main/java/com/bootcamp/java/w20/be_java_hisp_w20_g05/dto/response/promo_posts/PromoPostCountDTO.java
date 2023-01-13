package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoPostCountDTO {
    private int user_id;
    private long promo_products_count;
    private String user_name;
}
