package com.bootcamp.be_java_hisp_w20_g7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoDto {

    private int userId;
    private int postId;
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
