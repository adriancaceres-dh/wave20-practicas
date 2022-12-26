package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class IngredientsRepositoryImpl implements IngredientRepositoryI{
    private List<IngredientDTO> database;

    @Override
    public List<IngredientDTO> ingredients() {
        return database;
    }

    private IngredientsRepositoryImpl() {
        this.database = loadJsonData();
    }


    private static List<IngredientDTO> loadJsonData(){
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:food.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
            List<IngredientDTO> ingredients = null;
            try {
                ingredients = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ingredients;

    }
}
