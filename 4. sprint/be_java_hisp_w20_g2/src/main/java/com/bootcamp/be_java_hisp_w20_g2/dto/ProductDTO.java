package com.bootcamp.be_java_hisp_w20_g2.dto;

import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDTO(Product product) {
        productId = product.getId();
        productName = product.getName();
        type = product.getType();
        brand = product.getBrand();
        color = product.getColor();
        notes = product.getNotes();
    }
}
