package com.bootcamp;

public class Vaca extends Animal implements Hervivoro,ComerAnimal{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuu");
    }

    @Override
    public void comer() {
        System.out.println("La vaca está comiendo hierba");
    }
}
