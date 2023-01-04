package com.example.persona.model.dtos;

import com.example.persona.model.enums.NivelEnum;

public class DeporteDto {
    private String Nombre;
    private String Nivel;


    public DeporteDto(String nombre, NivelEnum nivel) {
        Nombre = nombre;
        Nivel = nivel.name();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }
}
