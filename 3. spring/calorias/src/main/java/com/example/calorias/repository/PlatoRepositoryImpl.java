package com.example.calorias.repository;

import com.example.calorias.model.Ingrediente;
import com.example.calorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements PlatoRepositoryInterface{

    private List<Ingrediente> ingredientes;
    private List<Plato> platos = new ArrayList<>();

    public PlatoRepositoryImpl() {
        readIngredientesFromJsonFile();
        createSomePlatos();
    }

    private void readIngredientesFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:food.json");
            ingredientes = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println("Problema al leer los ingredientes");
            throw new RuntimeException(e);
        }
    }

    private void createSomePlatos() {
        Plato ensalada = new Plato("Ensalada");
        ensalada.addIngrediente(getIngredienteByName("Calabaza"));
        ensalada.addIngrediente(getIngredienteByName("Cebolla"));
        ensalada.addIngrediente(getIngredienteByName("Col"));
        ensalada.addIngrediente(getIngredienteByName("Coliflor"));
        platos.add(ensalada);

        Plato polloConPapas = new Plato("Pollo con papas");
        polloConPapas.addIngrediente(getIngredienteByName("Pollo"));
        polloConPapas.addIngrediente(getIngredienteByName("Papas cocidas"));
        platos.add(polloConPapas);
    }

    private Ingrediente getIngredienteByName(String name) {
        return ingredientes.stream().
                filter(i -> i.getNombre().equals(name))
                .findFirst()
                .get();
    }

    @Override
    public List<Plato> getAllPlatos() {
        return platos;
    }

    @Override
    public Plato getPlatoByName(String nombre) {
        Optional<Plato> plato =  platos.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst();

        return plato.orElse(null);
    }
}
