package com.bootcamp.Covid19.service;

import com.bootcamp.Covid19.dto.PersonaDTO;
import com.bootcamp.Covid19.model.Persona;
import com.bootcamp.Covid19.model.Sintoma;

import java.util.*;
import java.util.stream.Collectors;

public class PersonaService {
    private final Map<Sintoma, List<Persona>> personaConSintoma;
    public PersonaService(){
        Sintoma Fiebre = new Sintoma("codigo1", "Fiebre", "Moderado");
        Sintoma DolorDeCabeza = new Sintoma("codigo2", "Dolor de cabeza", "Leve");

        personaConSintoma = new HashMap<>();

        List<Persona> personaList = new ArrayList<>();
        personaList.add(new Persona(1L, "Mi abuelo", "Ambroggio", 80));
        personaList.add(new Persona(2L, "Mi abuela", "Ambroggio", 79));
        personaList.add(new Persona(3L, "Lio", "Messi", 35));

        List<Persona> personaList2 = new ArrayList<>();
        personaList2.add(new Persona(4L, "Mi otro abuelo", "Ambroggio", 70));
        personaList2.add(new Persona(5L, "Mi otro abuela", "Ambroggio", 60));

        personaConSintoma.put(Fiebre, personaList);
        personaConSintoma.put(DolorDeCabeza, personaList2);
    }
    public PersonaDTO mapper(Persona persona){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setEdad(persona.getEdad());
        return personaDTO;
    }
    public List<Persona> agrupar(List<List<Persona>> listas){
        List<Persona> resultado = new ArrayList<>();
        for (List<Persona> lista : listas){
            resultado.addAll(lista);
        }
        return resultado;
    }
    public List<PersonaDTO> encontrarPersona(){
        List<List<Persona>> listas = personaConSintoma.values().stream().distinct().collect(Collectors.toList());

        List<Persona> personas = this.agrupar(listas);
        List<Persona> riesgo = personas.stream().filter(elem -> elem.getEdad() >= 60).collect(Collectors.toList());
        return riesgo.stream().map(this::mapper).collect(Collectors.toList());
    }

}
