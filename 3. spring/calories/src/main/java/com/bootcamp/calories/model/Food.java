package com.bootcamp.calories.model;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Food {
    private String name;
    private List<Ingredient> ingredients;
    private int totalCalories;

    public Food(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        totalCalories=calculateCalories();
    }

    private int calculateCalories() {
        return ingredients.stream().mapToInt(i->i.getCalories()).sum();
    }
}
