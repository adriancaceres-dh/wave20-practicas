package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CaloriasRepositoryImpl implements CaloriasRepository{

    private List<Ingrediente> databaseIngredientes;

    public CaloriasRepositoryImpl(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        com.fasterxml.jackson.core.type.TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        databaseIngredientes = ingredientes;
    }


    @Override
    public Ingrediente getIngredienteByName(String name) {
        try {
            return databaseIngredientes.stream().filter(ingrediente -> ingrediente.getNombre().equals(name)).findFirst().get();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }



}
