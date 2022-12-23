package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PersonaRiesgoDTO;
import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Sintoma;

import java.util.*;
import java.util.stream.Collectors;

public class PersonaService {
    public SintomaService sintomaService;
    public final List<Persona> personas;

    public PersonaService() {
        this.sintomaService = new SintomaService();
        this.personas = new ArrayList<>(Arrays.asList(
                new Persona(1, "Luis", "López", 25, new HashSet<>(
                        Arrays.asList("FI", "DC")
                )),
                new Persona(2, "Carlos", "Ruiz", 34, new HashSet<>(
                        Arrays.asList("TO", "FA", "DG")
                )),
                new Persona(3, "Roberto", "Alves", 75, new HashSet<>(
                        Arrays.asList("FI", "DG", "NA")
                )),
                new Persona(4, "Martha", "Chávez", 63, new HashSet<>(
                        Arrays.asList("FI", "FA", "DC", "DG")
                ))
        ));
    }

    public List<PersonaRiesgoDTO> getPersonasRiesgo() {
        Set<String> sintomasRiesgo = sintomaService.getSintomasRiesgo();

        List<Persona> personasRiesgo = personas.stream().filter(persona -> persona.getEdad() > 60)
                .filter(persona -> persona.getSintomas().stream().anyMatch(sintomasRiesgo::contains))
                .collect(Collectors.toList());

        List<PersonaRiesgoDTO> personasRiesgoDTO = new ArrayList<>();

        for(Persona persona : personasRiesgo) {
            PersonaRiesgoDTO personaRiesgoDTO = new PersonaRiesgoDTO();
            persona.getSintomas().retainAll(sintomasRiesgo); // Guardar la intersección de sets (retener los síntomas de riesgo)

            Set<Sintoma> sintomasRiesgoPersona = persona.getSintomas().stream()
                    .map(sintoma -> sintomaService.getSintomaByCodigo(sintoma).get())
                    .collect(Collectors.toSet());

            personaRiesgoDTO.setId(persona.getId());
            personaRiesgoDTO.setNombreCompleto(persona.getNombre() + " " + persona.getApellido());
            personaRiesgoDTO.setEdad(persona.getEdad());
            personaRiesgoDTO.setSintomasRiesgo(sintomasRiesgoPersona);

            personasRiesgoDTO.add(personaRiesgoDTO);
        }

        return personasRiesgoDTO;
    }
}
