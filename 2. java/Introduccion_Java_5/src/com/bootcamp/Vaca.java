package com.bootcamp;

public class Vaca extends Animal implements ComerHierva {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerAnimal() {
        comeHierva();
        System.out.println("La vaca esta comiendo...");
    }

    @Override
    public void comeHierva() {
        System.out.println("La vaca come hierva");
    }
}
