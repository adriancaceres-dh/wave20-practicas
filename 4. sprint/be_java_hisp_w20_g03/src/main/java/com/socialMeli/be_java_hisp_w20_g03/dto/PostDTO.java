package com.socialMeli.be_java_hisp_w20_g03.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostDTO {
    private int user_id;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;

}
