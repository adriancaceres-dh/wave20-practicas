package com.bootcamp.appcalorias.dto;

public class IngredientDto {
    private String name;
    private int calories;

    public IngredientDto(){

    }

    public IngredientDto(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
