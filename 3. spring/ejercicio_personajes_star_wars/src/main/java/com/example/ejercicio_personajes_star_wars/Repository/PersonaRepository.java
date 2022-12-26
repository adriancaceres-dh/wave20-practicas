package com.example.ejercicio_personajes_star_wars.Repository;

import com.example.ejercicio_personajes_star_wars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository implements IPersonajeRepository {

    List<Personaje> personajes;
    public PersonaRepository(){
        personajes = loadDatabase();
    }

    public List<Personaje> findAll(){
        return personajes;
    }

    public List<Personaje> findByName(String name){
        return personajes.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
    }

    public List<Personaje> loadDatabase() {
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
            characters = objectMapper.readValue(file,typeRef);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
