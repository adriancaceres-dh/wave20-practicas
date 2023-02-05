package com.bootcamp.clothes_no_relational.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GarmentDTO {

    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double price;
}
