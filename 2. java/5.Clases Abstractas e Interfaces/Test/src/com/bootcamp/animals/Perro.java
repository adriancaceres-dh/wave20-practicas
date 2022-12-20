package com.bootcamp.animals;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
    }

    @Override
    public void sonidoAnimal() {
        System.out.println("El perro hace Guuuaaaauuuuu");
    }

    public boolean comeCarne() {
        System.out.print("Es carnivoro: ");
        return true;
    }
}
