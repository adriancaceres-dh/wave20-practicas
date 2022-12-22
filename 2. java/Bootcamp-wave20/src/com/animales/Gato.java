package com.animales;

public class Gato extends Animal implements ICarnivoro{
    @Override
    public String emitirSonido() {
        return "Miauuuuu";
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
