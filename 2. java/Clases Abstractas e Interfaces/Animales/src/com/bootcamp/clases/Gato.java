package com.bootcamp.clases;

import com.bootcamp.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
