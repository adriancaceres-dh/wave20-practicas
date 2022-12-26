package com.bootcamp.calorias.dto;

import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Getter
public class PlatoDto {
    private String name;
    private double weight;
    private double totalCalories;
    private List<Ingrediente> ingredients;
    private Optional<Ingrediente> mostCaloricIngredient;

    public PlatoDto() {}

    public PlatoDto(Plato plato, double weight) {
        if (plato != null) {
            name = plato.getName();
            this.weight = weight;
            totalCalories = plato.getTotalCalories() * weight;
            ingredients = plato.getIngredients();
            mostCaloricIngredient = plato.getIngredients().stream()
                    .max(Comparator.comparingDouble(Ingrediente::getCalories));
        }
    }
}
