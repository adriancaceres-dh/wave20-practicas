package com.example.deportistas.service;

import com.example.deportistas.dto.PersonaDeportistaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {
    public final DeporteService deporteService;
    public final List<Persona> personas;

    public PersonaService() {
        this.deporteService = new DeporteService();
        this.personas = new ArrayList<>(Arrays.asList(
                new Persona("Luis", "López", 25, new HashSet<>(
                        Arrays.asList("futbol", "box")
                )),
                new Persona("Carlos", "Ruiz", 34, new HashSet<>()),
                new Persona("Roberto", "Alves", 75, new HashSet<>()),
                new Persona("Martha", "Chávez", 63, new HashSet<>(
                        Arrays.asList("futbol", "golf", "tenis", "basquetbol")
                ))
        ));
    }

    public List<PersonaDeportistaDTO> obtenerDeportistas() {
        List<Persona> deportistas = personas.stream().filter(persona -> !persona.getDeportes().isEmpty())
                .collect(Collectors.toList());

        List<PersonaDeportistaDTO> deportistasDTO = new ArrayList<>();

        for(Persona deportista : deportistas) {
            PersonaDeportistaDTO personaDeportistaDTO = new PersonaDeportistaDTO();
            personaDeportistaDTO.setNombre(deportista.getNombre());
            personaDeportistaDTO.setApellido(deportista.getApellido());
            personaDeportistaDTO.setDeportes(deportista.getDeportes().toString());

            deportistasDTO.add(personaDeportistaDTO);
        }

        System.out.println(deportistasDTO.size());

        return deportistasDTO;
    }
}
