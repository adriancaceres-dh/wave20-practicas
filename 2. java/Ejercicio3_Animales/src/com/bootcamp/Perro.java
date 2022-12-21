package com.bootcamp;

public class Perro extends Animal implements ICarnivoro{
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}
