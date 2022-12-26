package com.example.starwars.repository;

import com.example.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:personajes.json");
            personajes = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println("Hubo un fallo al leer el .json");
            throw new RuntimeException(e);
        }

    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Personaje> getPersonajesByName(String name) {
        return personajes.stream()
                .filter(personaje -> personaje.getName().toUpperCase().contains(name.toUpperCase()))
                .collect(Collectors.toList());
    }

}
