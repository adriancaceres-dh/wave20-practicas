package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bootcamp.starwars.dto.response.PersonajeDTO;
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
        this.database = inicializarBD();
    }

    public List<Personaje> buscarPersonajePorNombre(String nombre) {
        return database.stream()
                .filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Personaje> buscarTodos() {
        return database;
    }


    private List<Personaje> inicializarBD() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
        };
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
