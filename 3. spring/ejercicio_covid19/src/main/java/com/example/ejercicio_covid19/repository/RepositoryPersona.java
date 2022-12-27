package com.example.ejercicio_covid19.repository;

import com.example.ejercicio_covid19.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryPersona {

    List<Persona> personas;
    public RepositoryPersona(){
        RepositorySintoma repositorySintoma = new RepositorySintoma();
        personas = new ArrayList<>();
        personas.add(new Persona(1,"Tomas","Gonzalez",22,new ArrayList<>()));
        personas.add(new Persona(2,"Avelardo","Romero",82, Arrays.asList(
                repositorySintoma.findByName("Tos"),repositorySintoma.findByName("Fiebre")
        )));
        personas.add(new Persona(3,"Socorro","Perez",62,new ArrayList<>()));
    }

    public List<Persona> findAll(){
        return personas;
    }
}
