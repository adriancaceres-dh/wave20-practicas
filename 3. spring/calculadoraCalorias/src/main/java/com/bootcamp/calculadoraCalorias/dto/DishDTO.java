package com.bootcamp.calculadoraCalorias.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Builder
@Data
public class DishDTO {

    String name;
    List<IngredientDTO> ingredient;
    int totalCalories;
    String mostCaloricIngredient;

    public DishDTO() {
    }


    private String calculateMostCaloricIngredient(List<IngredientDTO> ingredient){
        if (ingredient.size() > 0){
            return ingredient.stream().max(Comparator.comparing(i -> i.caloriesSubtotal)).get().name;
        }
        throw new RuntimeException();
    }
    public DishDTO(String name, List<IngredientDTO> ingredient, int totalCalories) {
        this.name = name;
        this.ingredient = ingredient;
        this.totalCalories = totalCalories;
        this.mostCaloricIngredient = calculateMostCaloricIngredient(ingredient);

    }

    public DishDTO(String name, List<IngredientDTO> ingredient, int totalCalories, String mostCaloricIngredient) {
        this.name = name;
        this.ingredient = ingredient;
        this.totalCalories = totalCalories;
        this.mostCaloricIngredient = calculateMostCaloricIngredient(ingredient);
    }
}
