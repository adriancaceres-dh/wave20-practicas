package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Impresion{
    String nombre;
    int edad;
    List<String> habilidades;

    public Curriculum(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }
}
