package com.bootcamp.DtoResponseEntity.repository;

import com.bootcamp.DtoResponseEntity.model.Persona;
import com.bootcamp.DtoResponseEntity.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaRepository {
    List<Persona> personaList = new ArrayList<>();

    public Persona guardarPersona(Persona persona){
        personaList.add(persona);
        return persona;
    }

    public List<Persona> listaDePersonas(){
        return personaList;
    }

    //sin terminar
    public List<Persona> listaPersonaConSintoma(String nombre){
            List <Persona> personasMayores= new ArrayList<>();
            personaList.stream().map(persona -> persona.getEdad() > 60).collect(Collectors.toList());
           // List<Persona> personasConSintomas = new ArrayList<>();
            //personasMayores.stream().filter(persona -> persona.getSintomasList().stream().filter(p-> p.getNombre().equalsIgnoreCase(nombre)).isParallel()).collect(Collectors.toList());
            return personasMayores ;
    }
}
