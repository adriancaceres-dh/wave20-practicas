package com.bootcamp.calculadoraCalorias.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Dish {

    String name;
    List<String> ingredients;

    public Dish() {
        //default constructor
    }

    public Dish(String name, List<String> ingredientsName) {
        this.name = name;
        this.ingredients = ingredientsName;
    }

    public Dish(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
