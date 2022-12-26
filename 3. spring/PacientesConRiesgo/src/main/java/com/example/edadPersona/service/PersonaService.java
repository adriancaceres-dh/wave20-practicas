package com.example.edadPersona.service;

import com.example.edadPersona.DTO.PersonaDTO;
import com.example.edadPersona.entity.Persona;
import com.example.edadPersona.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    public List<Persona> personaList;
    public SintomaService sintomaService;

    public PersonaService() {
        Persona persona1 = new Persona(1L, "Rod", "Cab", 24, new HashSet<>(Arrays.asList("FI", "DC")));
        Persona persona2 = new Persona(2L, "lio", "messi", 24, new HashSet<>(Arrays.asList("FA", "NA")));
        Persona persona3 = new Persona(3L, "dibu", "martinez", 64, new HashSet<>(Arrays.asList("TO", "DC", "NA", "FI")));
        this.personaList = Arrays.asList(persona1, persona2, persona3);
        this.sintomaService = new SintomaService();
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }
    public List<PersonaDTO> getPersonasConRiesgo(){
        Set<Sintoma> sintomasRiesgo = sintomaService.getSintomasRiesgo();
        List<Persona> personasRiesgo = personaList.stream()
                .filter(persona -> persona.getEdad()>60)
                .filter(persona -> persona.getSintomas().stream().anyMatch(sintomasRiesgo::contains)).collect(Collectors.toList());
        List<PersonaDTO> personaDTOS = new ArrayList<>();
        for (Persona persona: personasRiesgo
             ) {
            PersonaDTO personaRiesgoDTO = new PersonaDTO();
            persona.getSintomas().retainAll(sintomasRiesgo);

            Set<Sintoma> sintomas = persona.getSintomas().stream()
                    .map(sintoma->sintomaService.getSintomaByCode(sintoma).get()).collect(Collectors.toSet());
            personaRiesgoDTO.setId(persona.getId());
            personaRiesgoDTO.setNombreCompleto(persona.getNombre()+" "+persona.getApellido());
            personaRiesgoDTO.setEdad(persona.getEdad());
            personaRiesgoDTO.setSintomasRiesgo(sintomas);
            personaDTOS.add(personaRiesgoDTO);
        }
        return personaDTOS;
    }
}
