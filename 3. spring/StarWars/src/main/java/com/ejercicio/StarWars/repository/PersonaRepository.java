package com.ejercicio.StarWars.repository;

import com.ejercicio.StarWars.modelo.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class PersonaRepository {
    private List<Personaje> listaPersonajes;
    public PersonaRepository(){
        this.listaPersonajes = loadDataBase();
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

    public List<Personaje> getListaPersonajes() {
        this.listaPersonajes.stream().forEach(System.out::println);
        return this.listaPersonajes;
    }
}
