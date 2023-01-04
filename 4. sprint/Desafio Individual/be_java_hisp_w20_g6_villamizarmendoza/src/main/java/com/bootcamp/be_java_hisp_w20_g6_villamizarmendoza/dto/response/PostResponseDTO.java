package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
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
