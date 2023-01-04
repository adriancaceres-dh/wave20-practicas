package com.bootcamp.be_java_hisp_w20_g4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromotionDTO extends PostDTO{

    private boolean has_promo;
    private double discount;
}
