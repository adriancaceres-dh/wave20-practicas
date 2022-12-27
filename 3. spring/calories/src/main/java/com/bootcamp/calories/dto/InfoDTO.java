package com.bootcamp.calories.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class InfoDTO {
    String name;
    double totalCalories;
    List<IngredientDTO> ingredientDTOS;
    String nameIngredient;
}
