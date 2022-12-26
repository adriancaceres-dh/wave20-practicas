package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PersonaDTO;
import com.bootcamp.covid.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    private final List<Persona> personas;

    public PersonaService () {
        personas = new ArrayList<>();
    }

    public String addPersona (Persona persona) {
        personas.add(persona);
        return persona.getNombre();
    }

    public List<PersonaDTO> listarPersonasDeRiesgo () {
        return personas.stream()
                .filter(p -> p.getEdad() > 60)
                .filter(p -> p.getSintomas().size() > 0)
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido()))
                .collect(Collectors.toList());
    }
}
