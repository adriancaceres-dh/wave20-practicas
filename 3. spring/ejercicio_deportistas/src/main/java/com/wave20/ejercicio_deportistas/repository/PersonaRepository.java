package com.wave20.ejercicio_deportistas.repository;

import com.wave20.ejercicio_deportistas.DTO.DeporteDTO;
import com.wave20.ejercicio_deportistas.DTO.PersonaDTO;
import com.wave20.ejercicio_deportistas.model.Deporte;
import com.wave20.ejercicio_deportistas.model.Persona;

import java.util.*;

public class PersonaRepository {

    private static Set<Persona> personas = new HashSet<>();


    public Optional<Persona> agregarPersona(PersonaDTO persona) {
        if (personas.stream().filter(p -> p.getNombre().equals(persona.getNombre())).findAny().isPresent()) {
            return Optional.empty();
        } else {
            Persona p = new Persona(persona.getNombre(), persona.getApellido(), persona.getEdad());
            personas.add(p);
            return Optional.of(p);
        }

    }

    public Optional<Persona> eliminarPersona(String nombre)  {
        Optional<Persona> persona = personas.stream().filter(p -> p.getNombre().equals(nombre)).findAny();
        if (persona.isPresent()) {
            personas.remove(persona.get());
            return Optional.of(persona.get());
        } else {
            return Optional.empty();
        }
    }


    public Optional<Persona> getPersona(String nombre) {
        return personas.stream().filter(d -> d.getNombre().equals(nombre)).findAny();


    }

    public Set<Persona> getPersonas() {
        return personas;
    }

}
