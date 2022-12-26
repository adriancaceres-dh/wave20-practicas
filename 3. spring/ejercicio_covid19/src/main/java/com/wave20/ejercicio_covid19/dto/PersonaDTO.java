package com.wave20.ejercicio_covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonaDTO {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
