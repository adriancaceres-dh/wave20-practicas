package com.bootcamp._vivo_dto_ej2.repository;

import com.bootcamp._vivo_dto_ej2.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private static List<Persona> repositorioPersonas = new ArrayList<>();

    public static List<Persona> getAll(){
        return repositorioPersonas;
    }

    public static Boolean addPersona(Persona persona){
        return repositorioPersonas.add(persona);
    }
}
