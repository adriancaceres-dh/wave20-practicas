package com.bootcamp.covid.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private Set<String> sintomas;

    public Persona(long id, String nombre, String apellido, int edad, HashSet<String> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(Set<String> sintomas) {
        this.sintomas = sintomas;
    }
}
