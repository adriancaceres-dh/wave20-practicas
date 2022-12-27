package com.bootcamp.calculadoracalorias.repository;

import com.bootcamp.calculadoracalorias.dto.response.FoodDto;
import com.bootcamp.calculadoracalorias.model.Dish;
import com.bootcamp.calculadoracalorias.model.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository {

    private List<Food> database;

    public FoodRepository() {
        database = loadDataBase();
    }

    private List<Food> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Food>> typeRef = new TypeReference<>() {
        };
        List<Food> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }

    public Food agregarIngredienteRandom() {
        return database.get((int) (Math.random() * (database.size() - 1) + 1));
    }

    public int cantIngredientes(){
        return (int)(Math.random()*5 + 1);
    }
}
