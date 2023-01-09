package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository("test")
public class IPersonajeImpl implements IPersonaje {

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {

        //List<Personaje> personajeList = personajesList.stream().filter(p -> p.getName().startsWith(nombre))
        //        .peek(w -> System.out.println("w = " + w)).collect(Collectors.toList());
        List<Personaje> personajeList = ConvertidorToPersonaje.obtenerPersonajes().stream().filter(p -> p.getName().startsWith(nombre))
                .collect(Collectors.toList());
        //peek rastrea el flujo la lista (imprime los valores que se cumplan bajo esa condicion)
        //System.out.println("personajeList = " + personajeList);

        return personajeList;
    }
}
