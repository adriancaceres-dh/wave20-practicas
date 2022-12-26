package com.bootcamp.starwars.repositories;

import com.bootcamp.starwars.dto.response.PersonajeResponseDto;
import com.bootcamp.starwars.model.Personaje;
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
public class PersonajeRepositoryImpl implements IPersonajeRepository{

    private final List<Personaje> database;

    public PersonajeRepositoryImpl() {
        this.database = loadDataBase();
    }

    @Override
    public List<Personaje> findAllByNameContains(String query) {
        return database.stream()
                .filter(personaje -> matchWith(query, personaje))
                .collect(Collectors.toList());
    }

    public List<PersonajeResponseDto> findAllByNameContainsDto(String query) {
        return database.stream()
                .map(personaje -> new PersonajeResponseDto(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .filter(personajeResponseDto -> personajeResponseDto.getName().toUpperCase().contains(query.toUpperCase()))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, Personaje personaje) {
        return personaje.getName().toUpperCase().contains(query.toUpperCase());
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
}
