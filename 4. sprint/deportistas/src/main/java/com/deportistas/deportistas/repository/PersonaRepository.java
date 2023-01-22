package com.deportistas.deportistas.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.deportistas.deportistas.models.Persona;

@Repository
public class PersonaRepository {

    private List<Persona> listaPersonas;

    public void aniadirPersona() {
        Persona persona = new Persona("Joe", "BOrges", 15, "Hookey", 2);
        listaPersonas = new ArrayList<>();
        listaPersonas.add(persona);
        persona = new Persona("Luis", "Gato", 25, "Fútbol", 6);
        listaPersonas.add(persona);
        persona = new Persona("Lucas", "Chuflún", 55, "baseball", 200);
        listaPersonas.add(persona);

    }

    public List<Persona> listarPersonas() {
        aniadirPersona();
        return listaPersonas;
    }
}
