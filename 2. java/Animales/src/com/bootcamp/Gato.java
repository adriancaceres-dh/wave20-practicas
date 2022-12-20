package com.bootcamp;

public class Gato extends Animal implements CarnivoroInterface {

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau!");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato y estoy comiendo carne");
    }
}
