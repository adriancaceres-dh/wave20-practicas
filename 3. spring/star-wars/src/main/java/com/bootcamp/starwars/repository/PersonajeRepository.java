package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{


    private final List<Personaje> database;


    public PersonajeRepository(){
        this.database = loadDatabase();
    }


    @Override
    public Personaje getPersonaje() {
        return null;
    }

    @Override
    public List<Personaje> getPersonajesByName(String name) {
        return database.stream().filter(personaje -> personaje.getName().toLowerCase(Locale.ROOT).contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Personaje> loadDatabase(){
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
