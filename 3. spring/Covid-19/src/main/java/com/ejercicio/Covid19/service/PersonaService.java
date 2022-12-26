package com.ejercicio.Covid19.service;

import com.ejercicio.Covid19.model.Persona;
import com.ejercicio.Covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {
    private List<Persona> personas;

    public PersonaService(){
        this.personas = new ArrayList<>();
        personas.add(new Persona(1,"Maria","Sanchez",23,new Sintoma(1345,"Varicela","Medio")));
        personas.add(new Persona(2,"Mathias","Rodriguez",45,new Sintoma(1350,"Infeccion","Bajo")));
        personas.add(new Persona(3,"Romina","Perez",69,new Sintoma(1380,"Covid-19","Alto")));
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Persona> personasDeRiego(){
        List<Persona> personasRiesgo = new ArrayList<>();
        personasRiesgo = personas.stream().filter(x->x.getEdad()>60).collect(Collectors.toList());
        if(personasRiesgo.isEmpty()){
            return null;
        }else{
            return personasRiesgo;
        }
    }
}
