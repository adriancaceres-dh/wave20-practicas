package com.animales;

public class Vaca extends Animal implements IHerviboro{
    @Override
    public String emitirSonido() {
        return "Muuuuuuuuu";
    }


    @Override
    public void comerVegetal() {
        System.out.println("Comiendo vegetal");
    }
}
