package com.bootcamp.PersonajesStarWars.Respository;

import com.bootcamp.PersonajesStarWars.DTO.PersonajesDto;
import com.bootcamp.PersonajesStarWars.Models.Personajes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRespositorio {

    private List<Personajes> personajesEnBD;

    public PersonajeRespositorio(List<Personajes> personajesEnBD) {
        this.personajesEnBD = loadDataBase();
    }

    public List<Personajes> getPersonajesEnBD() {
        return personajesEnBD;
    }

    private List<Personajes> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:3. starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personajes>> typeRef = new TypeReference<>() {};
        List<Personajes> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
