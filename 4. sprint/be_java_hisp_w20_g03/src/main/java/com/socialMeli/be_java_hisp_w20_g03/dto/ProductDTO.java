package com.socialMeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDTO {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_name")
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
