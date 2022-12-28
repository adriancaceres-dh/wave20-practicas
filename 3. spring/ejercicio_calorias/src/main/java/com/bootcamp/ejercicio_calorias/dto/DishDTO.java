package com.bootcamp.ejercicio_calorias.dto;

import com.bootcamp.ejercicio_calorias.model.Ingredient;

import java.util.List;

public class DishDTO
{
    private List<Ingredient> ingredients;
    private double calories;
    private Ingredient most_calories;

    public DishDTO(List<Ingredient> ingredients, double calories, Ingredient most_calories) {
        this.ingredients = ingredients;
        this.calories = calories;
        this.most_calories = most_calories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Ingredient getMost_calories() {
        return most_calories;
    }

    public void setMost_calories(Ingredient most_calories) {
        this.most_calories = most_calories;
    }
}
