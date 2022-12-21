package com.bootcamp;

public class Vaca extends Animal implements IHerbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }
}
