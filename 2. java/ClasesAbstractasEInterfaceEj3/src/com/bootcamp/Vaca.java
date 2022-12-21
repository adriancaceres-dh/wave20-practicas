package com.bootcamp;



public class Vaca extends Animal implements iAlimento{

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Lo siento no como carne carnal");
    }

    @Override
    public void comerHierba() {
        System.out.println("comiendo hierbas, soy herviboro");
    }
}
