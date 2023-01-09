package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ConvertidorToPersonaje {
    public static List<Personaje> obtenerPersonajes() {
        List<Personaje> personajesList = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            personajesList = Arrays.asList(mapper.readValue(Paths.get("starwars.json").toFile(), Personaje[].class));
            System.out.println("personajesList json = " + personajesList);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return personajesList;
    }
}
