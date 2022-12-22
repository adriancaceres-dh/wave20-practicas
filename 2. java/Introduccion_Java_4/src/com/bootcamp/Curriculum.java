package com.bootcamp;

import java.util.List;

public class Curriculum{
    String nombre;
    String apellido;
    List<String> estudios;
    public Curriculum(String nombre, String apellido, List<String> estudios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estudios = estudios;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estudios=" + estudios +
                '}';
    }
}
