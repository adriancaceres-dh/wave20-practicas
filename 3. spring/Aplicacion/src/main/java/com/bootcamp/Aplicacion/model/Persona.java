package com.bootcamp.Aplicacion.model;

public class Persona {
    String nombre;
    String apellido;
    int edad;
    Deporte deporte;

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

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Persona(String nombre, String aprllido, int edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = aprllido;
        this.edad = edad;
        this.deporte = deporte;
    }
}
