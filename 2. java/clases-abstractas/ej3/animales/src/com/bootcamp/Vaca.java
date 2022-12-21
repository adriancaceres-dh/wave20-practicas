package com.bootcamp;

public class Vaca extends Animal implements iHerviboro{

    @Override
    void emitirSonido() {
        System.out.println("muuu");
    }

    void comer () {
        iHerviboro.comerHierba();
    }
}
