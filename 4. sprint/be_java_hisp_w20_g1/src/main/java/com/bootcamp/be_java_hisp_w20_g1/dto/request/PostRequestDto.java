package com.bootcamp.be_java_hisp_w20_g1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private int userId;
    private LocalDate date;
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private int category;
    private double price;

}
