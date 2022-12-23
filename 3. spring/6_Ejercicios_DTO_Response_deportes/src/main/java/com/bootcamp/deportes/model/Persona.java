package com.bootcamp.deportes.model;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Integer> deportes;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, List<Integer> deportes) {
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

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", deportes=" + deportes +
                '}';
    }

    public List<Integer> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Integer> deportes) {
        this.deportes = deportes;
    }

}
