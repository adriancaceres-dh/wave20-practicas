package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.model.Personaje;
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
public class PersonajeRepository{
    private final List<Personaje> database;

    public PersonajeRepository() {
        this.database = loadDataBase();
    }
    public List<Personaje> getPersonajes(){
        return database;
    }
    public List<Personaje> getPersonajeByName(String name) {
        return database.stream().filter(personaje -> coincide(name, personaje)).collect(Collectors.toList());
    }
    private boolean coincide(String name, Personaje personaje) {
        return personaje.getName().toUpperCase().contains(name.toUpperCase());
    }
    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
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

}
