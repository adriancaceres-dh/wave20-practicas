package com.example.ejercicioopcional.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClothDTO {

    private Integer code;

    private String name;

    private String type;

    private String brand;

    private String color;

    private Integer size;

    private Integer quantity;

    private Double price;

}
