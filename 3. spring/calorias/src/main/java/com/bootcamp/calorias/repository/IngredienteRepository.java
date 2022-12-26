package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredienteRepository {
    private List<Ingrediente> ingredients;

    public IngredienteRepository() {
        ingredients = new ArrayList<>();
        try{
            File jsonFile = ResourceUtils.getFile("classpath:food.json");
            List<Ingrediente> ingredientsFromJson = new ObjectMapper().readValue(jsonFile, new TypeReference<>(){});
            ingredients.addAll(ingredientsFromJson);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Ingrediente findByName(String name) {
        return ingredients.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    public double getIngredientCaloriesByName(String name) {
        return findByName(name).getCalories();
    }
}
