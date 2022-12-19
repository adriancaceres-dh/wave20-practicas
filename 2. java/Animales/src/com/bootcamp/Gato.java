package com.bootcamp;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comer() {
        System.out.println("gato comiendo carne");
    }
}
