package com.bootcamp.ejercicio_calorias.service;

import com.bootcamp.ejercicio_calorias.model.Ingredient;

import java.util.List;

public interface IIngredientService {

    public List<Ingredient> getAll();
    public Ingredient getByName(String name);

}
