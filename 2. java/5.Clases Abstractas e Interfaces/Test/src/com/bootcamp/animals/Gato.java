package com.bootcamp.animals;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    @Override
    public void sonidoAnimal() {
        System.out.println("El gato hace Miaaauuuu");
    }

    public boolean comeCarne() {
        System.out.print("Es carnivoro: ");
        return true;
    }
}
