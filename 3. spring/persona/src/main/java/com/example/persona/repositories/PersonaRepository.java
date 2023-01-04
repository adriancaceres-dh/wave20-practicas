package com.example.persona.repositories;

import com.example.persona.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PersonaRepository {
    private static List<Persona> Personas = new ArrayList<Persona>(List.of(
            new Persona("1111", "Ana", "Ruiz", 23),
            new Persona("2222", "Juan", "Martinez", 18, 1),
            new Persona("333", "Jose", "Diaz", 36, 3),
            new Persona("4444", "Lucia", "Correa", 21),
            new Persona("5555", "Pablo", "Rodriguez", 52, 4),
            new Persona("11232", "Maria", "Pereira", 41, 2)));

    public List<Persona> getPersonas(){
        return Personas;
    }

}
