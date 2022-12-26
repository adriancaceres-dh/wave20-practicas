package com.bootcamp.Deportistas.service;

import com.bootcamp.Deportistas.dto.PersonaDTO;
import com.bootcamp.Deportistas.model.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonaService {
    private Map<String, List<Persona>> mapaPersonas;
    public PersonaService() {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Lio", "Messi", 35));
        personas.add(new Persona("Fideo", "DiMaria",34));

        mapaPersonas = new HashMap<>();
        mapaPersonas.put("Futbol", personas);
        System.out.println(mapaPersonas.get("Futbol"));

    }
    public  List<PersonaDTO> encontrarDeportistas(String deporte){
        if (deporte.isEmpty()){
            System.out.println("Deporte no encontrado");
        }
        List<Persona> personas1 = mapaPersonas.get(deporte);
        System.out.println(personas1);
        return personas1.stream().map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), deporte)).collect(Collectors.toList());
    }

}
