package com.spring.covid19.dto;

import java.io.Serializable;

public class SintomaDTO implements Serializable {
    public SintomaDTO(String nombre, int nivelDeGravedad) {
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public SintomaDTO() {
    }

    private String nombre;
    private int nivelDeGravedad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
