package com.example.ejercicio_calculadora_calorias.repository;

import com.example.ejercicio_calculadora_calorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {

    List<Ingredient> findAll();
    Ingredient findByName(String name);
}
