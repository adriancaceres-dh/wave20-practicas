package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("product_name")
    private String name;

    private String type;

    private String brand;

    private String color;

    private String notes;

}
