package com.bootcamp.Calculadora.de.calorias.repository;

import com.bootcamp.Calculadora.de.calorias.model.Ingrediente;
import com.bootcamp.Calculadora.de.calorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientesRepositoryImpl implements IIngredientesRepository {


    private final List<Ingrediente> database;


    public IngredientesRepositoryImpl() {
        this.database = loadDataBase();
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
        List<Ingrediente> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }

    @Override
    public List<Ingrediente> ingredintes() {

        //database.stream().filter(x->x.getNombre().equals("Tallarines")).findFirst().get().getCalorias();
        return this.database;
    }


}
