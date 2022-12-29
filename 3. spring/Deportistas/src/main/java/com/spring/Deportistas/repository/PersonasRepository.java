package com.spring.Deportistas.repository;

import com.spring.Deportistas.model.Deporte;
import com.spring.Deportistas.model.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonasRepository {
    public static List<Persona> personas = new ArrayList<>();


    public List<Persona> personas() {
        return personas;
    }

    public List<Persona> deportistas() {
        return personas.stream().filter(e -> e.getDeportesPracticando() !=null && !e.getDeportesPracticando().isEmpty()).collect(Collectors.toList());
    }
}
