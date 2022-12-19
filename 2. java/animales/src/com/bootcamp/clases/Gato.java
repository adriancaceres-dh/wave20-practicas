package com.bootcamp.clases;

import com.bootcamp.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Perro comiendo animal del tipo: " + animal.getTipo() + " y especie: " + animal.getClass().getSimpleName());
    }
}
