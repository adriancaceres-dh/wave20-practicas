package com.bootcamp;

public class Persona {

    public static boolean tienePelo() {
        return true;
    }

    private String nombre;

    public Persona() {

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

    public boolean jugar(int numero) {
        return numero == (int)(Math.random()*10+1);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
