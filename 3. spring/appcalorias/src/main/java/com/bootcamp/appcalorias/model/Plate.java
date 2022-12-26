package com.bootcamp.appcalorias.model;

import java.util.List;

public class Plate {
    private String name;

    private List<Ingredient> ingredients;

    public Plate(String name, List<Ingredient> ingredientes) {
        this.name = name;
        this.ingredients = ingredientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
