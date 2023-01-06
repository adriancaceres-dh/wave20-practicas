package com.bootcamp.deportistas.model;

import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporteRealizado;

    public Persona(String nombre, String apellido, int edad, Deporte deporteRealizado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporteRealizado = deporteRealizado;
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

    public Deporte getDeporteRealizado() {
        return deporteRealizado;
    }

    public void setDeporteRealizado(Deporte deporteRealizado) {
        this.deporteRealizado = deporteRealizado;
    }
}
