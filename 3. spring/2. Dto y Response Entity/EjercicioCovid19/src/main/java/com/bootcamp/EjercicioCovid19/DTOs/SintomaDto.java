package com.bootcamp.EjercicioCovid19.DTOs;

public class SintomaDto {

    private final  String nombre;
    private final Integer codigo, nivel_de_gravedad;

    public SintomaDto(String nombre, Integer codigo, Integer nivel_de_gravedad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }
}
