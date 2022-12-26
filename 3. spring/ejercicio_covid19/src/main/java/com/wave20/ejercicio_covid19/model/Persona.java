package com.wave20.ejercicio_covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
