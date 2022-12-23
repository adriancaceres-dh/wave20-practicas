package com.dto.deportistas.model;

public class DeporteModel {
    private String nombre;
    private String nivel;

    public DeporteModel() {
    }

    public DeporteModel(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "{" +'\n' +
                "nombre: '" + nombre + '\n' +
                ", nivel: '" + nivel + '\n' +
                '}';
    }
}
