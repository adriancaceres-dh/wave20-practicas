package com.bootcamp.prueba.Dto;

import com.bootcamp.prueba.model.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CalorieDataDto {

    private double totalCalories;
    private List<Ingredient> ingredientList;
    private Ingredient highestCalorieIngredient;
}
