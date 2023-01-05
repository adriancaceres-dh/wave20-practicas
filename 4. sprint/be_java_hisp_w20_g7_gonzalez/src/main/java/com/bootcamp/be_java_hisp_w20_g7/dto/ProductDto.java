package com.bootcamp.be_java_hisp_w20_g7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
