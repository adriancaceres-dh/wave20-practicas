package com.bootcamp._dto_p2.dto;

import lombok.Getter;

@Getter
public class PersonaDTO {

    private String nombre,apellido;

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
