package com.example.deportistas.models;

public class Persona {
    private String nombre;
    private String apellido;
    private Deporte deporte; //
    private int edad;

    public Persona(String nombre, String apellido, Deporte deporte, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
        this.edad = edad;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
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

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
