package com.DtoYResponseEntityP2PG.Covid19;

import java.util.List;

public class Persona {
    int id;
    String nombre;
    int edad;
    String apellido;

    List<Sintoma> sintomas;

    public Persona(){};

    public Persona(int id, String nombre, int edad, String apellido, List<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }

    public int getId() {
        return id;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
