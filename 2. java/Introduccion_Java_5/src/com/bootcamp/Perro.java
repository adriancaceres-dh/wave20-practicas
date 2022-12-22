package com.bootcamp;

public class Perro extends Animal implements ComerCarne{
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerAnimal() {
        comeCarne();
        System.out.println("EL perro esta comiendo...");
    }

    @Override
    public void comeCarne() {
        System.out.println("EL perro come carne");
    }
}
