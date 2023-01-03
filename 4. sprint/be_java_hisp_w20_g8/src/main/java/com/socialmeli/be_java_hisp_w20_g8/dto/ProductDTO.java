package com.socialmeli.be_java_hisp_w20_g8.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder


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
