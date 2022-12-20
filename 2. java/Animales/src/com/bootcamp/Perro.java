package com.bootcamp;

public class Perro extends Animal implements Carnivoro,ComerAnimal{
    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

    @Override
    public void comer() {
        System.out.println("perro comiendo carne");
    }
}
