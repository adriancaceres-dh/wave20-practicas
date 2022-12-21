package com.bootcamp;

public class Gato extends Animal implements iCarnivoro{
    @Override
    void emitirSonido() {
        System.out.println("miau");
    }

    void comer () {
        iCarnivoro.comerCarne();
    }
}
