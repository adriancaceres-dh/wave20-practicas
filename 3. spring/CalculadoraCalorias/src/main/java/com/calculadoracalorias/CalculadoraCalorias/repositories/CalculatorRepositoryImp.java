package com.calculadoracalorias.CalculadoraCalorias.repositories;


import com.calculadoracalorias.CalculadoraCalorias.dto.FoodDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CalculatorRepositoryImp implements CalculatorRepository{

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public List<FoodDto> findAllFood() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TypeReference<List<FoodDto>> typeRef = new TypeReference<>() {};
        List<FoodDto> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
