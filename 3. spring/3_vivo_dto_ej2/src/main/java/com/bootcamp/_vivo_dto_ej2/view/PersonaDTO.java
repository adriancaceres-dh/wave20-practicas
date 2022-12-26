package com.bootcamp._vivo_dto_ej2.view;

import lombok.Getter;

@Getter
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private int edad;

    public PersonaDTO(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
