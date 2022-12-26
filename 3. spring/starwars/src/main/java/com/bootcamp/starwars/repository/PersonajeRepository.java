package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository {
    private List<Personaje> personajes;

    public PersonajeRepository() {
        personajes = new ArrayList<>();
        try {
            File charactersJson = ResourceUtils.getFile("classpath:starwars_characters.json");
            List<Personaje> personajes = new ObjectMapper().readValue(charactersJson, new TypeReference<>() {
            });
            this.personajes.addAll(personajes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Personaje> getAll() {
        return personajes;
    }

    public Optional<Personaje> find(Predicate<Personaje> predicate) {
        return personajes.stream()
                .filter(predicate)
                .findFirst();
    }

    public List<Personaje> findAll(Predicate<Personaje> predicate) {
        return personajes.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public boolean save(Personaje personaje) {
        return personajes.add(personaje);
    }

    public boolean saveAll(List<Personaje> personajes) {
        return this.personajes.addAll(personajes);
    }

    public boolean delete(Personaje personaje) {
        return personajes.remove(personaje);
    }

}
