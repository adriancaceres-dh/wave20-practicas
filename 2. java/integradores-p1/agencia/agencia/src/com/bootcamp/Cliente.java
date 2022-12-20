package com.bootcamp;

public class Cliente {
    String dni;
    String nombre;
    String apellido;
    boolean descuentoLocalizadores;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descuentoLocalizadores = false;
    }
}


