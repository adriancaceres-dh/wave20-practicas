package com.bootcamp.deportes.service;

import com.bootcamp.deportes.dto.response.PersonaResponseDto;
import com.bootcamp.deportes.model.Persona;
import com.bootcamp.deportes.model.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonaService {
    List<Persona> personas;
    DeporteService deporteService;

    public PersonaService() {
        deporteService = new DeporteService();
        Persona persona1 = new Persona("Manuel","Diaz",36, List.of(1, 3));
        Persona persona2 = new Persona("Benjamin","Gomez",40, List.of(1));
        this.personas = List.of(persona1, persona2);
    }

    public List<PersonaResponseDto> personasDeportistas(){
        Map<Integer, String> deportesPorId = deporteService.todosLosDeportes()
                .stream()
                .collect(Collectors.toMap(Deporte::getId, Deporte::getNombre));
        return personas.stream()
                .flatMap(persona -> persona.getDeportes()
                        .stream()
                        .map(deporteId -> new PersonaResponseDto(
                                persona.getNombre(),
                                persona.getApellido(),
                                deportesPorId.get(deporteId))))
                .collect(Collectors.toList());
    }
}
