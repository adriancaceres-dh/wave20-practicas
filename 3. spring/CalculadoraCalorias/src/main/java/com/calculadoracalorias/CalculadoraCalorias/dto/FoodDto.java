package com.calculadoracalorias.CalculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class FoodDto {
    private String name;
    private String calories;
}
