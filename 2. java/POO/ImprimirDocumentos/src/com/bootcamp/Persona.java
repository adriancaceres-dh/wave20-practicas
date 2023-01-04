package com.bootcamp;

public class Persona {
    private String nombre;
    private String dni;
    private String telefono;
    private String carrera;

    public Persona(String nombre, String dni, String telefono, String carrera) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
