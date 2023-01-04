package com.example.persona.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Persona {
    private String DNI;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private int Deporte;

    public Persona(String DNI, String nombre, String apellido, int edad) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }

    public Persona(String DNI, String nombre, String apellido, int edad, int deportes) {
        this.DNI = DNI;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Deporte = deportes;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getDeportes() {
        return Deporte;
    }
}

