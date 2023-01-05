package com.bootcamp.be_java_hisp_w20_g6.dto.request;

import java.time.LocalDate;

import com.bootcamp.be_java_hisp_w20_g6.model.ProductModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostRequestDto {
    private int user_id;
    private String date;
    private int category;
    private ProductModel product;
    private double price;
    private boolean has_promo;
    private double discount;
}
