package com.bootcamp.covid.dto;

import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;

    public PersonaDTO(Persona persona, List<Sintoma> sintomas) {
        nombre = persona.getNombre();
        apellido = persona.getApellido();
        edad = persona.getEdad();
        this.sintomas = sintomas;
    }
}
