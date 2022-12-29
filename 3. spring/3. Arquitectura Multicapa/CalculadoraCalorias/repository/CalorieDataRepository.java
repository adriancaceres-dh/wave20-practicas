package com.bootcamp.prueba.repository;

import com.bootcamp.prueba.model.Dish;
import com.bootcamp.prueba.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Collectors;


@Repository
public class CalorieDataRepository {
    private final List<Dish> dishDataBase;
    private final List<Ingredient> ingredientDataBase;

    private List<Ingredient> loadIngredients() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public CalorieDataRepository() {
        this.dishDataBase = new ArrayList<>();
        this.ingredientDataBase = loadIngredients();
    }

    public Dish getDishByName(String name) {
        return dishDataBase.stream()
                .filter(dish -> dish.getName().contains(name))
                .findFirst().orElse(null);
    }
}
