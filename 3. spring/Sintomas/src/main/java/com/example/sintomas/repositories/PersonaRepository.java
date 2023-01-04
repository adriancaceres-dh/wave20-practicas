package com.example.sintomas.repositories;

import com.example.sintomas.entities.Persona;
import com.example.sintomas.entities.Sintoma;
import com.example.sintomas.enums.NivelGravedadEnum;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class PersonaRepository {

    private static Set<Persona> Personas = new HashSet<>(
            List.of(new Persona(1111, "Ana","S", 22, new HashSet<>(List.of(1,2))),
                    new Persona(2222, "Rocio","J", 45, new HashSet<>(List.of(2))),
                    new Persona(3333, "Jose", "Z",67, new HashSet<>(List.of(3, 1))),
                    new Persona(4444,"Luis", "A", 63),
                    new Persona(1323, "Lucia", "N", 31)));

    public static Set<Persona> getPersonas() {
        return Personas;
    }

    public static void addPersonas(Set<Persona> personas) {
        Personas.addAll(personas);
    }
    public static void removePersonas(Set<Persona> personas) {
        Personas.removeAll(personas);
    }
}
