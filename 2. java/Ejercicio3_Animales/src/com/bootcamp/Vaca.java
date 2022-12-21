package com.bootcamp;

public class Vaca extends Animal implements IHerviboro{
    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
