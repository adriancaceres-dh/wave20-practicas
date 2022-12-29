package com.spring.Deportistas.model;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> deportesPracticando;

    public Persona(String nombre, String apellido, int edad, List<Deporte> deportesPracticando) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportesPracticando = deportesPracticando;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Deporte> getDeportesPracticando() {
        return deportesPracticando;
    }

    public void setDeportesPracticando(List<Deporte> deportesPracticando) {
        this.deportesPracticando = deportesPracticando;
    }
}
