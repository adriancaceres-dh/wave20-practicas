package com.bootcamp;

public class Perro extends Animal implements iCarnivoro{
    @Override
    void emitirSonido() {
        System.out.println("guau");
    }

    void comer () {
        iCarnivoro.comerCarne();
    }
}
