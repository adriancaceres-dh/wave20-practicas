package com.socialmeli.be_java_hisp_w20_g8.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductDTO {
    @JsonProperty("product_id")
    private int product_id;
    @JsonProperty("product_name")
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
