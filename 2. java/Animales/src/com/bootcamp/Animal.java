package com.bootcamp;

public abstract class Animal {

    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void sonido() {

    }

    public void comer() {

    }

    public static void comerAnimal(Animal a) {
        a.comer();
    }
}
