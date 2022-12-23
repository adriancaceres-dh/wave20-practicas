package com.bootcamp.claseDos.model;

public class Personaje {

    private String nombre;
    private String empresa;

    public Personaje(String nombre, String empresa) {
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
