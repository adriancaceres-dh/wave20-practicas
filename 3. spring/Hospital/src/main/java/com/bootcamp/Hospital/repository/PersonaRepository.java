package com.bootcamp.Hospital.repository;

import com.bootcamp.Hospital.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaRepository {
    private List<Persona> personas = new ArrayList<>();

    public Persona savePerson(Persona persona){
        personas.add(persona);
        return persona;
    }

    public List<Persona> consultarPersonas(){
        return personas;
    }

    public Persona findPerson(String id){
        Optional<Persona> persona =  personas.stream().filter(p -> p.getId().equals(id)).findFirst();
        return persona.isPresent() ? persona.get():null;
    }



}
