package com.example.ejercicio_deportistas.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;

    private List<Deporte> deportes;

    public Persona() {}

    public Persona(String nombre, String apellido, int edad) {
        this.deportes = new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
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
}
