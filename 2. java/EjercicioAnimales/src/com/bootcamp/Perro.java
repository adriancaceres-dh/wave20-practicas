package com.bootcamp;

public class Perro extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }
}
