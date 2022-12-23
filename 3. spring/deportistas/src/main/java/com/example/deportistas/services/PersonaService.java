package com.example.deportistas.services;

import com.example.deportistas.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    private final List<Persona> personas = new ArrayList<>();

    public boolean addPersona(Persona persona) {
        personas.add(persona);
        return true;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

}
