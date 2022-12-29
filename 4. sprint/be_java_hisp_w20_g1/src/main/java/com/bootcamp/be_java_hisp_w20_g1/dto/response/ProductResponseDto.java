package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
