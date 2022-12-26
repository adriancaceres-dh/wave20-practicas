package com.ejercicio.deportistas.service;


import com.ejercicio.deportistas.model.Deporte;
import com.ejercicio.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonasService {

    private List<Persona> personas;

    public PersonasService(){
        this.personas = new ArrayList<>();
        this.personas.add(new Persona("Tammara","Trivelli",26,new Deporte("Tenis","Principiante")));
        this.personas.add(new Persona("Rodolfo","Perez",23,new Deporte("Futbol","Avanzado")));
        this.personas.add(new Persona("Maria","Sanchez",40,new Deporte("Ajedrez","Intermedio")));
    }

    public List<Persona> devuelvePersona(){
        return personas;
    }
}
