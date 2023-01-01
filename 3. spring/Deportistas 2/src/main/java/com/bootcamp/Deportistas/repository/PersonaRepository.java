package com.bootcamp.Deportistas.repository;

import com.bootcamp.Deportistas.model.Deporte;
import com.bootcamp.Deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository {

    List<Persona> personas;
    List<Deporte> deportesDiego;
    List<Deporte> deportesCamila;

    public PersonaRepository(){

        personas = new ArrayList<>();

        deportesDiego = new ArrayList<>();
        deportesDiego.add(new Deporte("Futbol","Pro player"));
        deportesDiego.add(new Deporte("Valorant", "Noob"));

        deportesCamila = new ArrayList<>();
        deportesCamila.add(new Deporte("Baloncesto","Pro player"));
        deportesCamila.add(new Deporte("Volleyball", "Pro player"));

        personas.add(new Persona("Diego", "Malagon",23,deportesDiego));
        personas.add(new Persona("Camila", "Cardenas",23,deportesCamila));
        personas.add(new Persona("Maria","Malagon",56,null));

    }

    public List<Persona> getPersonas(){
        return personas;
    }
    public List<Persona> getDeportistas(){

        return personas.stream().filter(persona -> persona.getDeportes()!=null).collect(Collectors.toList());
    }



}
