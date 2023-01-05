package com.bootcamp.be_java_hisp_w20_g4.dto.response.publication;


import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PromotionPublicationCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
