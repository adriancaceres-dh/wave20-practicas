package com.wave20.ejercicio_covid19.repository;

import com.wave20.ejercicio_covid19.model.Persona;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {

    List<Persona> personas = new ArrayList<>();

    public PersonaRepository() {
        personas.add(new Persona(1, "Pablo", "Diaz", 64));
        personas.add(new Persona(1, "Jose", "Gomez", 62));
        personas.add(new Persona(1, "Marta", "Gutierrez", 34));
        personas.add(new Persona(1, "Mariana", "Dominguez", 32));
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}
