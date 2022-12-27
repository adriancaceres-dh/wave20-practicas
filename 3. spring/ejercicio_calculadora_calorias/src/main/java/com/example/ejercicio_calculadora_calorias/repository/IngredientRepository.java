package com.example.ejercicio_calculadora_calorias.repository;

import com.example.ejercicio_calculadora_calorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepository implements IIngredientRepository{


    public IngredientRepository(){
        System.out.println("hohoh");
    }

    @Override
    public List<Ingredient> findAll() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
    @Override
    public Ingredient findByName(String name){

        return findAll().stream().filter(e -> e.getName().equals(name)).findFirst().get();
    }
}
