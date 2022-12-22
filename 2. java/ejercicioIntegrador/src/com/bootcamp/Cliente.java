package com.bootcamp;

public class Cliente {
    Integer dni;
    String nombre;
    String apellido;

    public Cliente() {

    }

    public Cliente(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "DNI: "+this.dni+", Nombre: "+ this.nombre + ", Apellido: " + this.apellido;
    }
}
