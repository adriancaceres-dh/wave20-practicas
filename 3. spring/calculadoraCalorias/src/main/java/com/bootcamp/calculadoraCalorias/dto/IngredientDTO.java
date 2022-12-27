package com.bootcamp.calculadoraCalorias.dto;

import com.bootcamp.calculadoraCalorias.model.Ingredient;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IngredientDTO {

    String name;
    int caloriesIn100Gr;
    int caloriesSubtotal;

    public IngredientDTO(String name, int calories) {
        this.name = name;
        this.caloriesIn100Gr = calories;
        this.caloriesSubtotal = calories;
    }

    public IngredientDTO(String name, int calories, int caloriesSubtotal) {
        this.name = name;
        this.caloriesIn100Gr = calories;
        this.caloriesSubtotal = caloriesSubtotal;
    }

    public IngredientDTO() {
        // Default constructor
    }

    public IngredientDTO(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.caloriesIn100Gr = ingredient.getCalories();
    }


}
