package com.bootcamp;

public class Perro extends Animal implements iAlimento{
    @Override
    public void emitirSonido() {
        System.out.println("guauuu");

    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne, soy carnivoro");
    }

    @Override
    public void comerHierba() {
        System.out.println("Lo siento, no como hierba carnal");
    }
}
