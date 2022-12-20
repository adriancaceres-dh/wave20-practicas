package com.bootcamp.clases;

import com.bootcamp.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
