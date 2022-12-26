package com.bootcamp.calculadora_calorias.repository;

import com.bootcamp.calculadora_calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository {
    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl() {
        ingredientes = loadDataBase();
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
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Optional<Ingrediente> obtenerIngredientePorNombre(String nombre) {
        // return ingredientes.stream().max(Comparator.comparingInt(Ingrediente::getCalorias));
        return ingredientes.stream().filter(ingrediente -> ingrediente.getNombre().equals(nombre)).findFirst();
    }
}
