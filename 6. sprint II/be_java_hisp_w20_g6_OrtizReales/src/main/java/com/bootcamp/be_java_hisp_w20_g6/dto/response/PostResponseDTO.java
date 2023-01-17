package com.bootcamp.be_java_hisp_w20_g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

import com.bootcamp.be_java_hisp_w20_g6.model.ProductModel;
@AllArgsConstructor
@Getter
public class PostResponseDTO {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductModel product;
    private int category;
    private double price;


}
