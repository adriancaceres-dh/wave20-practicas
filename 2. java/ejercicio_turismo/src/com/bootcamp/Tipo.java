package com.bootcamp;

public class Tipo
{
    private String nombre;

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
