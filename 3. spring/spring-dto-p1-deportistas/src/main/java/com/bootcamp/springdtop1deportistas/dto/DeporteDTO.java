package com.bootcamp.springdtop1deportistas.dto;

public class DeporteDTO {
    private String nombre;
    private String nivel;

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
