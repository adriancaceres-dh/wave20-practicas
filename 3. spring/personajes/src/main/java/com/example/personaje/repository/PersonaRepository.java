package com.example.personaje.repository;
import com.example.personaje.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    private final List<Personaje> personajeList;

    public PersonaRepository() {
        this.personajeList = loadDB();
    }


    public List<Personaje> loadDB(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
        };
        List<Personaje> personajeList = null;
        try {
            personajeList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajeList;
    }
    public List<Personaje> getPersonajeList() {
        return personajeList;
    }
}
