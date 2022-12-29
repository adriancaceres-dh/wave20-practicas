package com.covid19.covid19.dto;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class PersonaDTO implements Serializable {
    String nombre;
    String apellido;

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
