package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PromoPostRequestDTO extends PostRequestDTO{

    private boolean has_promo;
    private double discount;
}
