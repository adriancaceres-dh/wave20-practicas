package com.bootcamp;

public class Gato extends Animal implements IComerCarne{
    @Override
    void emitirSonido() {
        System.out.println("Miau!");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gatito carnivoro");
    }

}
