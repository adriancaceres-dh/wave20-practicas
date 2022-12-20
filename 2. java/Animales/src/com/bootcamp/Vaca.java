package com.bootcamp;

public class Vaca extends Animal implements HerbivoroInterface {

    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca y estoy comiendo hierba");
    }
}
