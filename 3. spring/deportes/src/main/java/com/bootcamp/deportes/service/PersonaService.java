package com.bootcamp.deportes.service;

import com.bootcamp.deportes.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaService {

    private static List<Persona> personaList;

    public PersonaService(List<Persona> ps) {
        personaList = ps;
    }

    public void agPersona (Persona p) {
        personaList.add(p);
    }

    public static List<Persona> getPersonaList() {
        return personaList;
    }

}
