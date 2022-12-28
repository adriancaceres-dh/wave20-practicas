package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Getter
@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository{

    private final List<Ingrediente> database;

    public IngredienteRepositoryImpl() {
        database = loadDataBase();
    }

    @Override
    public Ingrediente buscarIngrediente(String nombre) {
        return database.stream()
                .filter(d -> d.getName().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }
}
