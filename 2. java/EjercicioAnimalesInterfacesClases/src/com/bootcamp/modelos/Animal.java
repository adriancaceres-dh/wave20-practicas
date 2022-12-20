package com.bootcamp.modelos;

public abstract class Animal {
    protected String nombre;
    protected int Edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        Edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
    public abstract String emitirSonido();

}
