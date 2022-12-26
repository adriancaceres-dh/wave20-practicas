package com.bootcamp.appcalorias.repository;

import com.bootcamp.appcalorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Repository
public class IngridientRepositoryImp implements IIngredientRepository{

    private final List<Ingredient> database;

    public IngridientRepositoryImp() {
        this.database = loadDataBase();
    }

    @Override
    public Ingredient mostCalories(List<Ingredient> ingredients) {

        return ingredients.stream().max(Comparator.comparingInt(Ingredient::getCalories)).stream().findAny().get();
    }

    @Override
    public Ingredient getIngredient(int index) {
        return this.database.get(index);
    }

    private List<Ingredient> loadDataBase() {
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
}
