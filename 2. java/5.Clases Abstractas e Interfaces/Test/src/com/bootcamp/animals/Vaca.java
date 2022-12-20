package com.bootcamp.animals;

public class Vaca extends Animal implements Herbivoro {
    public Vaca() {
    }

    @Override
    public void sonidoAnimal() {
        System.out.println("La vaca hace Muuuuuu");
    }

    public boolean comeHierba() {
        System.out.print("Es herbivoro: ");
        return true;
    }

}
