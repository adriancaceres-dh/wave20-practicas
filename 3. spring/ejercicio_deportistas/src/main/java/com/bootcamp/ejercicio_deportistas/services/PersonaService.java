package com.bootcamp.ejercicio_deportistas.services;

import com.bootcamp.ejercicio_deportistas.dtos.PersonaDTO;
import com.bootcamp.ejercicio_deportistas.models.Deporte;
import com.bootcamp.ejercicio_deportistas.models.Persona;
import com.bootcamp.ejercicio_deportistas.services.interfaces.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {
    private List<Persona> personas;
    public PersonaService() {
        personas = new ArrayList<>();
        Persona persona = new Persona("fede","veron",22);
        List<Deporte> deportes = new ArrayList<>();
        deportes.add(new Deporte("Basquet",2));
        persona.setDeportes(deportes);
        personas.add(persona);
    }

    @Override
    public List<PersonaDTO> buscarDeportistas() {
        return personas.stream().map(x->
                new PersonaDTO(x.getNombre(),
                        x.getApellido(),
                        x.getDeportes().get(0).getNombre()))
                .collect(Collectors.toList());
    }
}
