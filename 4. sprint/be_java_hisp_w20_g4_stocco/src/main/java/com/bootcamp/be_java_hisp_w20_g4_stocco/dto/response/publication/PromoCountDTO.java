package com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;


}
