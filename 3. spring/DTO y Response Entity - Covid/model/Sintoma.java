package com.bootcamp.test.model;

public class Sintoma {
    private String codigo;
    private String nombre;
    private NivelDeGravedad nivelDeGravedad;

    public Sintoma(String codigo, String nombre, NivelDeGravedad nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelDeGravedad getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(NivelDeGravedad nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
