package com.ejercicio.Covid19.dto;

public class PersonDto {

    private String nombre;
    private String apelido;

    public PersonDto(String nombre, String apelido) {
        this.nombre = nombre;
        this.apelido = apelido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "nombre='" + nombre + '\'' +
                ", apelido='" + apelido + '\'' +
                '}';
    }
}
