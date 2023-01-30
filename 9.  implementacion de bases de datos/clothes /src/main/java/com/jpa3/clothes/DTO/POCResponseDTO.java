package com.jpa3.clothes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class POCResponseDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double price;
}
