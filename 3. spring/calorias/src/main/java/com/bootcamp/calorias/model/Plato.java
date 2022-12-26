package com.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Plato {
    private String name;
    private List<Ingrediente> ingredients;

    public boolean addIngrediente(Ingrediente ingrediente) {
        return ingredients.add(ingrediente);
    }

    public double getTotalCalories() {
        return ingredients.stream()
                .mapToDouble(Ingrediente::getCalories)
                .sum();
    }
}
