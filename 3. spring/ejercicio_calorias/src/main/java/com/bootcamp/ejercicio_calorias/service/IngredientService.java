package com.bootcamp.ejercicio_calorias.service;

import com.bootcamp.ejercicio_calorias.model.Ingredient;
import com.bootcamp.ejercicio_calorias.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IIngredientService{
    @Autowired
    private IIngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getByName(String name) {
        return ingredientRepository.findAllByNameContains(name);
    }
}
