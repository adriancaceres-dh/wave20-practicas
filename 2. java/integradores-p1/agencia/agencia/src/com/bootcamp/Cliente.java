package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String dni;
    String nombre;
    String apellido;
    List<Localizador> localizadoresContratados;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localizadoresContratados = new ArrayList<>();
    }

    public boolean agregarLocalizador(Localizador l) {
        if (l.cliente == this) {
            localizadoresContratados.add(l);
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + dni + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'';
    }
}


