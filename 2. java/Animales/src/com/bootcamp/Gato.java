package com.bootcamp;

public class Gato extends Animal implements Carnivoro,ComerAnimal{
    @Override
    public void emitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comer() {
        System.out.println("gato comiendo carne");
    }
}
