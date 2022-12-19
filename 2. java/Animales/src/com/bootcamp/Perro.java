package com.bootcamp;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

    @Override
    public void comer() {
        System.out.println("perro comiendo carne");
    }
}
