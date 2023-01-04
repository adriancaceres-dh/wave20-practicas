package com.socialMeli.be_java_hisp_w20_g03.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private String category;
    private String price;
}
