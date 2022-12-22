package com.bootcamp;

public class Gato extends Animal implements ComerCarne{
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerAnimal() {
        comeCarne();
        System.out.println("El gato esta comiendo...");
    }

    @Override
    public void comeCarne() {
        System.out.println("El gato come carne");
    }
}
