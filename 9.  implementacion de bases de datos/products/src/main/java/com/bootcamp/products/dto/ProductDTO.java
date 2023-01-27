package com.bootcamp.products.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductDTO {

    private Long id;
    private String name;
    private String type;
    private Double price;
    private Double cost;
    private Integer quantity;
}
