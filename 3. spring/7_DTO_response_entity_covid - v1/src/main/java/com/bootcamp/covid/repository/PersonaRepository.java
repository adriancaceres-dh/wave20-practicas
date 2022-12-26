package com.bootcamp.covid.repository;

import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    private List<Persona> personas;

    public PersonaRepository() {
        personas = new ArrayList<>();
        Persona per1 = Persona.builder()
                .id("1")
                .nombre("Juan")
                .apellido("Gomez")
                .fechaNacimiento(LocalDate.of(1960,6,1))
                .sintomas(new ArrayList<>())
                .build();
        per1.agregarSintoma(new Sintoma("S1","Tos","Bajo"));
        personas.add(per1);
        Persona per2 = Persona.builder()
                .id("2")
                .nombre("Maria")
                .apellido("Rot")
                .fechaNacimiento(LocalDate.of(1995,3,12))
                .sintomas(new ArrayList<>())
                .build();
        per2.agregarSintoma(new Sintoma("S1","Tos","Bajo"));
        personas.add(per2);
        Persona per3 = Persona.builder()
                .id("3")
                .nombre("Juana")
                .apellido("Cas")
                .fechaNacimiento(LocalDate.of(1950,3,12))
                .sintomas(new ArrayList<>())
                .build();
        per3.agregarSintoma(new Sintoma("S1","Tos","Bajo"));
        personas.add(per3);
    }

    public List<Persona> gerPersonas() {
        return personas;
    }

}
