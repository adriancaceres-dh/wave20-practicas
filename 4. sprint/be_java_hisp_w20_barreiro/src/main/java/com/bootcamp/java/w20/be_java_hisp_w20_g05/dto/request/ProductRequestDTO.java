package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {
    private int id;
    private String name;
    private String brand;
    private String type;
    private String color;
    private String notes;
}
