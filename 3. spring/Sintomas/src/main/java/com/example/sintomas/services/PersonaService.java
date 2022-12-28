package com.example.sintomas.services;

import com.example.sintomas.dtos.PersonaSintomaDto;
import com.example.sintomas.dtos.SintomaDto;
import com.example.sintomas.entities.Persona;
import com.example.sintomas.repositories.PersonaRepository;
import com.example.sintomas.repositories.SintomasRepository;

import java.util.Collection;
import java.util.Set;

public class PersonaService {
    private static PersonaRepository _repo = new PersonaRepository();
    private static SintomaService _sintomaService = new SintomaService();

    public Collection<PersonaSintomaDto> getPersonaConSintomas(){
        return _repo.getPersonas().stream()
                .filter(persona -> !persona.getSintomas().isEmpty() && persona.getEdad()>=60)
                .map(persona ->
                        new PersonaSintomaDto(persona.getNombre(),
                            persona.getApellido(),persona.getEdad(),_sintomaService.getByIds(persona.getSintomas())))
                .toList();
    }


}
