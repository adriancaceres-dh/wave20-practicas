package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    String nombre;
    double montoDisponible;

    public Cliente(String nombre, double montoDisponible) {
        this.nombre = nombre;
        this.montoDisponible = montoDisponible;
    }

    public Cliente() {
    }

    public double getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(double montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", montoDisponible=" + montoDisponible +
                '}';
    }
}
