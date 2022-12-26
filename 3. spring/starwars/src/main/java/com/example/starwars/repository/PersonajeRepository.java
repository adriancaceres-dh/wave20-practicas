package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class PersonajeRepository implements IPersonajeRepository{
    private List<Personaje> listaPersonajes;

    public PersonajeRepository() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:starwars.json");
            listaPersonajes = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println("Hubo un fallo al leer el .json");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Personaje> listaPersonajes() {
        return listaPersonajes;
    }

    @Override
    public List<Personaje> personajeXNombre(String nombre) {
        return listaPersonajes.stream().filter(filtro->filtro.getName().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList());
    }
}
