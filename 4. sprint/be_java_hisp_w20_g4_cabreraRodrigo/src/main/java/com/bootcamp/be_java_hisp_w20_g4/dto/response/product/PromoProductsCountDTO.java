package com.bootcamp.be_java_hisp_w20_g4.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoProductsCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
