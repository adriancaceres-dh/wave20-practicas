package com.bootcamp;

public class Vaca extends Animal implements IComerHierba{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy herbivoro");
    }

}
