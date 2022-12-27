package com.bootcamp._calculadora_calorias.repository;

import com.bootcamp._calculadora_calorias.model.IngredientEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredienteRepository{

    private List<IngredientEntity> database;

    public IngredientRepository(){this.database=loadDataBase();}

    public IngredientEntity getRandom(){
        return database.get((int) (Math.random()*(database.size()-1)+1));
    }

    private List<IngredientEntity> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:3. food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientEntity>> typeRef = new TypeReference<>() {};
        List<IngredientEntity> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
