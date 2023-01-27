package com.bootcamp.Employees.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String name;
    private String type;
    private Double sellPrice;
    private Double costPrice;
    private Integer cantAvailable;
}
