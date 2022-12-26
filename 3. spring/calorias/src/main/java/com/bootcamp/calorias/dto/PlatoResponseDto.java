package com.bootcamp.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PlatoResponseDto {
    private double calories;
    private List<IngredienteDto> ingredients;
    private IngredienteDto mostCaloricIngredient;
}
