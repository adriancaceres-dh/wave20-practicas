package com.bootcamp;

public abstract class Animal {
    protected String nombre;
    public abstract void emitirSonido();
    public abstract void comer();

    public Animal(String nombre) {
        this.nombre = nombre;
    }
}
