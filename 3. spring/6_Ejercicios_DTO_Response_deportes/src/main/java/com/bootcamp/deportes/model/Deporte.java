package com.bootcamp.deportes.model;

public class Deporte {

    private int id;
    private String nombre;
    private String nivel;

    public Deporte() {
    }

    public Deporte(int id,String nombre, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
