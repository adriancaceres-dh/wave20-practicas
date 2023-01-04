package com.bootcamp.prueba.repository;

import com.bootcamp.prueba.dto.PersonajeDto;
import com.bootcamp.prueba.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository{
    private final List<Personaje> baseDatosPersonajes;

    public StarWarsRepository() {
        this.baseDatosPersonajes = loadDataBase();
    }

    @Override
    public List<Personaje> getAll() {
        return baseDatosPersonajes;
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
        List<Personaje> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }
}
