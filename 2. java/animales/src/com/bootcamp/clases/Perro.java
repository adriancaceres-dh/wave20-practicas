package com.bootcamp.clases;

import com.bootcamp.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    public Perro(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Perro comiendo animal del tipo: " + animal.getTipo() + " y especie: " + animal.getClass().getSimpleName());
    }
}
