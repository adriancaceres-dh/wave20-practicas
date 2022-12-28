package com.bootcamp.EjercicioCovid19.DTOs;

import java.util.List;

public class PersonaDto {
    private final String nombre, apellido;
    private final List<String> sintomas;

    public PersonaDto(String nombre,String apellido, List<String> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido(){
            return apellido;
    }
    public List<String> getSintomas() {
        return sintomas;
    }

}
