package com.bootcamp.Starwars.repository;

import com.bootcamp.Starwars.dto.PersonajeDTO;
import com.bootcamp.Starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajesRepository{

    private final List<Personaje> database;

    public PersonajeRepositoryImpl() {
        this.database = loadDataBase();
    }


    private List<Personaje> loadDataBase() {
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

    @Override
    public List<Personaje> buscarTodos() {
        return this.database;
    }
}
