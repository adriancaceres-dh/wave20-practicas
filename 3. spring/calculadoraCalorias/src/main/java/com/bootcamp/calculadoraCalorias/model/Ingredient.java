package com.bootcamp.calculadoraCalorias.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient {
    String name;
    int calories;

    public Ingredient() {
        //default constructor
    }

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}
