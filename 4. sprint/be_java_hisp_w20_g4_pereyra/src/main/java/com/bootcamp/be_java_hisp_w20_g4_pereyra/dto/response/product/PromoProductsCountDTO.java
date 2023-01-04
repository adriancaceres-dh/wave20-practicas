package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoProductsCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
