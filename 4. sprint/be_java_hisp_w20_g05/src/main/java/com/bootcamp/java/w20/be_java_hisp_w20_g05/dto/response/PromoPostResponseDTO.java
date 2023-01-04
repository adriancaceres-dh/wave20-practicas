package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@Builder
public class PromoPostResponseDTO {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private PromoProductResponseDTO product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
