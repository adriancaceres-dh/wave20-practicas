package com.bootcamp.StarWars.repositories;

import com.bootcamp.StarWars.models.Personaje;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository {

    private final List<Personaje> database;

    public PersonajeRepository() {
        this.database = obtenerListadoPersonajes();
    }
    public List<Personaje> obtenerListadoPersonajes(){

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public List<Personaje> busquedaPersonajes(String texto) {
        return database.stream()
                .filter(personaje -> personaje.getName().contains(texto))
                .collect(Collectors.toList());
    }
}
