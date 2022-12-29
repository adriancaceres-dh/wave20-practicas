package com.covid19.covid19.service;

import com.covid19.covid19.dto.PersonaDTO;
import com.covid19.covid19.model.Persona;
import com.covid19.covid19.model.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    List<Persona> personas;
    public  PersonaService(){
        personas = new ArrayList<>();
        personas.add(new Persona("1", "nombre 1","apellido 1",12, Arrays.asList(
                new Sintoma("codigo_1","nombre_1","nivel 1"),
                new Sintoma("codigo_2","nombre_2","nivel 2")
        )));
        personas.add(new Persona("2", "nombre 2","apellido 2",78, Arrays.asList(
                new Sintoma("codigo_2","nombre_2","nivel 2"),
                new Sintoma("codigo_3","nombre_3","nivel 3")
        )));
        personas.add(new Persona("3", "nombre 3","apellido 3",62, Arrays.asList(
                new Sintoma("codigo_3","nombre_3","nivel 3"),
                new Sintoma("codigo_1","nombre_1","nivel 1")
        )));
    }
    public List<PersonaDTO> getPersonasRiesgo(){
        return personas.stream()
                .filter(p -> p.getEdad()>=60 && !p.getSintomas().isEmpty())
                .map(p -> new PersonaDTO(p.getNombre(),p.getApellido()))
                .collect(Collectors.toList());
    }
}
