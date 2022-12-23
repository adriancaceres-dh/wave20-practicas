package com.dto.deportistas.model;

public class PersonaModel {
    private String nombre;
    private String apellido;
    private int edad;

    public PersonaModel() {
    }

    public PersonaModel(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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
        return "{" +'\n' +
                "nombre: '" + nombre + '\n' +
                ", apellido: '" + apellido + '\n' +
                ", edad: " + edad +'\n' +
                '}';
    }
}
