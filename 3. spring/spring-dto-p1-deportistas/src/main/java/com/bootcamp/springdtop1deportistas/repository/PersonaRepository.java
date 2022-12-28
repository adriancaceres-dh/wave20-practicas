package com.bootcamp.springdtop1deportistas.repository;

import com.bootcamp.springdtop1deportistas.model.Deporte;
import com.bootcamp.springdtop1deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository implements IRepository<Persona> {

    private List<Persona> personas;

    public PersonaRepository() { personas = new ArrayList<>(); }

    @Override
    public List<Persona> filterByName(String name) {
        return personas.stream().filter(d -> d.getNombreApellido().toLowerCase()
                        .matches("^.*" + name.toLowerCase() + ".*$"))
                .collect(Collectors.toList());
    }

    public boolean contains(Persona persona) {
        List<Persona> personaPorNombreApellido = personas.stream()
                .filter(p -> p.getNombreApellido().toLowerCase().equalsIgnoreCase(persona.getNombreApellido())).collect(Collectors.toList());
        return personaPorNombreApellido.size() > 0;
    }

    @Override
    public boolean add(Persona persona) {
        if (contains(persona)) return false;
        personas.add(persona);
        return true;
    }
}
