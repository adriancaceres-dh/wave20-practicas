package com.bootcamp.ejercicio.covid.services;

import com.bootcamp.ejercicio.covid.dto.PersonaDTO;
import com.bootcamp.ejercicio.covid.models.Persona;
import com.bootcamp.ejercicio.covid.models.Sintoma;
import com.bootcamp.ejercicio.covid.services.interfaces.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SintomaService implements ISintomaService {

    private List<Sintoma> sintomas;
    private List<Persona> personas;
    public SintomaService() {

        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("1","Tos",1));
        sintomas.add(new Sintoma("2","Perdida de gusto",3));
        sintomas.add(new Sintoma("3","Fiebre",2));

        personas = new ArrayList<>();
        Persona persona = new Persona(1,"fede","veron",22);
        Persona maria = new Persona(2,"maria","perez",62);
        List<Sintoma> sintomasMaria = new ArrayList<>(Arrays.asList(sintomas.get(0)));
        maria.setSintomas(sintomasMaria);
        personas.add(persona);
        personas.add(maria);
    }


    @Override
    public List<Sintoma> buscarSintomas() {
        return this.sintomas;
    }

    @Override
    public Optional<Sintoma> buscarSintoma(String nombre) {
        Optional<Sintoma> sintoma = this.sintomas.stream()
                .filter(x -> x.getNombre().toLowerCase(Locale.ROOT)
                        .equals(nombre.toLowerCase(Locale.ROOT)))
                .findFirst();
        return sintoma;
    }

    @Override
    public List<PersonaDTO> buscarPersonasDeRiesgo() {
        List<PersonaDTO> personasDTO = new ArrayList<>();
        List<Persona> personas = this.personas.stream()
                .filter(x->x.getEdad() > 60 && x.getSintomas().size() > 0)
                .collect(Collectors.toList());
        for (Persona persona: personas
             ) {
            PersonaDTO personaDTO = new PersonaDTO(persona.getNombre(),persona.getApellido());
            personasDTO.add(personaDTO);

        }

        return personasDTO;

    }
}
