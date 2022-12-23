package com.example.covid.models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;

    public Persona(long id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        sintomas = new ArrayList<>();
    }

    public void addSintoma(Sintoma sintoma) {
        sintomas.add(sintoma);
    }

    public Persona() {
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

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }
}
