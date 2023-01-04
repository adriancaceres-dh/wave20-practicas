package com.example.sintomas.dtos;

import java.util.Collection;
import java.util.HashSet;
public class PersonaSintomaDto {
    private String nombre;
    private String apellido;
    private int edad;
    private Collection<SintomaDto> sintomas = new HashSet<>();

    public PersonaSintomaDto(String nombre, String apellido, int edad, Collection<SintomaDto> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
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

    public Collection<SintomaDto> getSintomas() {
        return sintomas;
    }

    public void setSintomas(Collection<SintomaDto> sintomas) {
        this.sintomas = sintomas;
    }
}
