package com.bootcamp.CalculadoraCalorias.repository;

import com.bootcamp.CalculadoraCalorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepository {
    private final List<Ingrediente> dataBase;

    public IngredienteRepository() {
        this.dataBase = loadDataBase();
    }

    public List<Ingrediente> getIngredientes(){
        return dataBase;
    }

    public Ingrediente getIngrediente(String name){
        Ingrediente resultado = null;
        Optional<Ingrediente> ingrediente = dataBase.stream().filter(ingrediente1 -> ingrediente1.getName().equals(name)).findFirst();
        if (ingrediente.isPresent())
            resultado = ingrediente.get();
        return resultado;
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
}
