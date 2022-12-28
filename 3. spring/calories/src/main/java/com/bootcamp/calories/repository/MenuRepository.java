package com.bootcamp.calories.repository;

import com.bootcamp.calories.model.Food;
import com.bootcamp.calories.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Repository
@Getter

public class MenuRepository {
    private List<Ingredient> ingredients;
    private List<Food> menu;

    public MenuRepository() {
        ingredients=loadIngredients();
        menu=createMenu();
    }

    private List<Food> createMenu() {
        List<Ingredient> ingredients1= Arrays.asList(ingredients.get(0),ingredients.get(8),ingredients.get(12));
        List<Ingredient> ingredients2= Arrays.asList(ingredients.get(4),ingredients.get(15),ingredients.get(11));
        List<Ingredient> ingredients3= Arrays.asList(ingredients.get(17),ingredients.get(9),ingredients.get(16));

        Food food1=new Food("asado",ingredients1);
        Food food2=new Food("hamburguesa",ingredients2);
        Food food3=new Food("estofado",ingredients3);

        return Arrays.asList(food1,food2,food3);
    }
    private List<Ingredient> loadIngredients() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Food> getMenu() {
        return menu;
    }
}
