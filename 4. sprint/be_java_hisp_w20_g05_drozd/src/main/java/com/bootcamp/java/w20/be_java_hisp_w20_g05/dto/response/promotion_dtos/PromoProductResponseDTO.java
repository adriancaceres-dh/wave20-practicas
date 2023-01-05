package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promotion_dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PromoProductResponseDTO {

    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
