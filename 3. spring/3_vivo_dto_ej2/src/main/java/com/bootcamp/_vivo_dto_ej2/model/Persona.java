package com.bootcamp._vivo_dto_ej2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Long id_deporte;

    public Persona(String nombre, String apellido, int edad, Long id_deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id_deporte = id_deporte;
    }
}
