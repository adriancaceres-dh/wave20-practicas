package com.bootcamp.contadorcalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DishDTOResponse {
    private int totalCalories;
    private List<IngredientDTO> ingredients;
    private IngredientDTO mostCaloricIngredient;
}
