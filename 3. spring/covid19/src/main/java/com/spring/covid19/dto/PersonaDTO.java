package com.spring.covid19.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private String id;
    private String nombreCompleto;
    private int edad;
    private String nombre;
    private int nivelDeGravedad;

    public PersonaDTO(){

    }
    public PersonaDTO(String id, String nombreCompleto, int edad, String nombre, int nivelDeGravedad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
