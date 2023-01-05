package com.bootcamp.be_java_hisp_w20_g4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int product_id;
    private String product_name;
    private String color;
    private String notes;
    private String type;
    private String brand;


}
