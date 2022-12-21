package com.bootcamp;

public class Gato extends Animal implements iAlimento{

    @Override
    public void emitirSonido() {
        System.out.println("Miaaaauuuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne, soy carnivoro");
    }

    @Override
    public void comerHierba() {
        System.out.println("lo siento no como hierba carnal");
    }
}
