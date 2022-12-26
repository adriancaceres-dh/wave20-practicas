package com.bootcamp._dto_p2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    private Long id;
    private String nombre, apellido;
    private int edad;

    public Persona(Long id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

}