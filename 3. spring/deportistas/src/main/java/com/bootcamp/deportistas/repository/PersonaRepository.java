package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaRepository {

    private List<Persona> personas;

    public PersonaRepository() {
        personas = new ArrayList<>();
        personas.add(new Persona("Juan","Gomez", LocalDate.of(1990,12,31),
            new Deporte("Tenis","1")));
        personas.add(new Persona("Pedro","Fernandez", LocalDate.of(1990,1,31),
                new Deporte("Futbool","1")));
        // no hace deporte
        personas.add(new Persona("Carlos","Ros", LocalDate.of(1993,1,3),
                null));
    }

    public List<Persona> personas() {
        return personas;
    }

    public List<Persona> deportistas() {
        return personas.stream().filter(e -> e.getDeporte()!=null).collect(Collectors.toList());
    }
}
