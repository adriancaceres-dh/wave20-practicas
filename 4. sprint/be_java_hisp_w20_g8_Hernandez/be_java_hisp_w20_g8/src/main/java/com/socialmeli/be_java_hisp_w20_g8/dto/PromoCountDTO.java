package com.socialmeli.be_java_hisp_w20_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PromoCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;

}
