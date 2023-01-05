package com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.product;

import com.bootcamp.be_java_hisp_w20_g4_stocco.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO extends Product {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
