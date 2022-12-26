package com.bootcamp.appcalorias.repository;

import com.bootcamp.appcalorias.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    public Ingredient mostCalories(List<Ingredient> ingredients);

    public Ingredient getIngredient(int index);
}
