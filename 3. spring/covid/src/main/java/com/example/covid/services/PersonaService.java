package com.example.covid.services;

import com.example.covid.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    private final List<Persona> personas;

    public PersonaService() {
        personas = new ArrayList<>();
    }

    public String addPersona(Persona persona) {
        personas.add(persona);
        return persona.getNombre();
    }

    public List<Persona> getRiskyPersons() {
        return personas.stream()
                .filter(p -> p.getEdad() > 60)
                .filter(s -> s.getSintomas().size() > 0)
                .collect(Collectors.toList());
    }
}
