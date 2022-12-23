package com.example.deportistas.model;

import java.util.List;
import java.util.Set;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Set<String> deportes;

    public Persona(String nombre, String apellido, int edad, Set<String> deportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportes = deportes;
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

    public Set<String> getDeportes() {
        return deportes;
    }

    public void setDeportes(Set<String> deportes) {
        this.deportes = deportes;
    }
}
