package com.bootcamp;

public class Perro extends Animal implements CarnivoroInterface {

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro, y estoy comiendo carne");
    }
}
