package com.bootcamp.be_java_hisp_w20_g6.dto.response;

import com.bootcamp.be_java_hisp_w20_g6.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDiscountResponseDto {

    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductModel product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;


}
