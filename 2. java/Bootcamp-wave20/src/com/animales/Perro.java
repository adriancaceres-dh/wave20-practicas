package com.animales;

public class Perro extends Animal implements ICarnivoro {


    @Override
    public String emitirSonido() {
        return "Gua guau guau";
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
