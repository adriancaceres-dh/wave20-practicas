package com.bootcamp.EjercicioCovid19.repositories;

import org.springframework.stereotype.Repository;
import com.bootcamp.EjercicioCovid19.models.Persona;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {

    List<Persona> listaPersonas ;

    public PersonaRepository() {
        this.listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona(1,26,"Franco","Alvarez"));
        listaPersonas.add(new Persona(2,57,"Sandra","Alvarado"));
        listaPersonas.add(new Persona(3,10,"Agustin","Alvarez"));
        listaPersonas.add(new Persona(4,60,"Sigifredo","Paredes"));
        listaPersonas.add(new Persona(5,87,"Olivia","Calisto"));
    }

    public List<Persona> getListaPersonas(){
        return listaPersonas;
    }
}
