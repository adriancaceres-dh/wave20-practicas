package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTORequest {
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
