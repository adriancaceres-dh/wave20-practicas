package com.example.sintomas.entities;

import java.util.HashSet;
import java.util.Set;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private Set<Integer> sintomas = new HashSet<>();

    public Persona(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(int id, String nombre, String apellido, int edad, Set<Integer> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
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

    public Set<Integer> getSintomas() {
        return sintomas;
    }

    public void addSintomas(Set<Integer> sintomas) {
        sintomas.addAll(sintomas);
    }
    public void removeSintomas(Set<Integer> sintomas) {
        sintomas.removeAll(sintomas);
    }
}
