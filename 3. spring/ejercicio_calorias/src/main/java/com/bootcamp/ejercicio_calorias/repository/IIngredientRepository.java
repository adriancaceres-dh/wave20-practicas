package com.bootcamp.ejercicio_calorias.repository;

import com.bootcamp.ejercicio_calorias.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    Ingredient findAllByNameContains(String query);
    List<Ingredient> findAll();

}
