package com.bootcamp;

import com.bootcamp.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println("prefiero el pescado pero está rica la carne");
    }
    @Override
    public void sonido() {
        System.out.println("miau miau miau");
    }
    @Override
    public void comer() {
        comerCarne();
    }
}
