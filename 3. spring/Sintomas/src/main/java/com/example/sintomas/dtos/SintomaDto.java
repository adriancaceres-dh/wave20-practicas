package com.example.sintomas.dtos;

import com.example.sintomas.enums.NivelGravedadEnum;

public class SintomaDto {
    private String nombre;
    private NivelGravedadEnum nivel_de_gravedad;

    public SintomaDto(String nombre, NivelGravedadEnum nivel_de_gravedad) {
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel_de_gravedad() {
        return nivel_de_gravedad.name();
    }

    public void setNivel_de_gravedad(NivelGravedadEnum nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
