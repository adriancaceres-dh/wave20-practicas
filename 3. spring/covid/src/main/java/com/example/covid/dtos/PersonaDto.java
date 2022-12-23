package com.example.covid.dtos;

import java.io.Serializable;

public class PersonaDto implements Serializable {
    private String nombre;
    private String apellido;

    public PersonaDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public PersonaDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
