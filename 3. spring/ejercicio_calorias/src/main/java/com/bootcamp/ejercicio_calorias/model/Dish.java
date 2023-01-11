package com.bootcamp.ejercicio_calorias.model;

import java.util.List;

public class Dish
{
    private List<Ingredient> ingredients;
    private double weight;
    private String name;


    public Dish() {
    }

    public Dish(List<Ingredient> ingredients, String name) {
        this.ingredients = ingredients;
        this.name = name;

        this.weight = 0;
        for (Ingredient ing : ingredients
        ) {
            this.weight += ing.getCalories()*0.1;
        }
    }

    public Dish(List<Ingredient> ingredients, double weight, String name) {
        this.ingredients = ingredients;
        this.weight = weight;
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
