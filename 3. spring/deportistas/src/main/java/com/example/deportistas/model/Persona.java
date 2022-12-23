package com.example.deportistas.model;

public class Persona {
    String nombre;
    String apellido;
    int edad;

    Deporte deporte;

    public Persona(String nombre, String apellido, int edad,Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte=deporte;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", deporte=" + deporte +
                '}';
    }
}
