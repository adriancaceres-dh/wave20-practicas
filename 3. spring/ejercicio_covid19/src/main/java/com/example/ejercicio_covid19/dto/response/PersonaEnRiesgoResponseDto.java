package com.example.ejercicio_covid19.dto.response;

import com.example.ejercicio_covid19.service.PersonaService;

public class PersonaEnRiesgoResponseDto {

    private String nombre;
    private String apellido;

    public PersonaEnRiesgoResponseDto(){};
    public PersonaEnRiesgoResponseDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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
