package com.bootcamp._dto_p2.repository;

import com.bootcamp._dto_p2.dto.PersonaDTO;
import com.bootcamp._dto_p2.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private static List<Persona> repositorioPersonas= new ArrayList<>();

    public static List<Persona> getAll(){
        return repositorioPersonas;
    }

    public static boolean addAll(List<Persona> personas){
        return repositorioPersonas.addAll(personas);
    }

    public static List<PersonaDTO> getRiskPersonDTO(){
        return null;
    }

    public static Persona get(int id){
        return repositorioPersonas.get(id);
    }

    public static Persona getByID(Long id){
        return repositorioPersonas.stream()
                        .filter(persona -> persona.getId()==id)
                        .findFirst().orElse(null);
    }

}
