package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {

    List<Persona> personas;

    public PersonaService() {
        personas = new ArrayList<>();

        personas.add(new Persona("Juan", "Lopez", 28, new Deporte("Baloncesto", "amateur")));
        personas.add(new Persona("Luis", "Ramos", 22, new Deporte("Beisbol", "profesional")));
        personas.add(new Persona("Pedro", "Ramirez", 34, new Deporte("Baloncesto", "amateur")));
    }

    public List<PersonaDTO> buscarDeportesPersonas() {
        return personas.stream().map(p -> new PersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())).collect(Collectors.toList());
    }
}
