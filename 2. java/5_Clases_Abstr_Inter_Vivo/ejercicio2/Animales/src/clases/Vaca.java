package clases;

import interfaces.iHerviboro;

public class Vaca extends Animal implements iHerviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuu!");
    }

    public void comer () {
        iHerviboro.comerHierba();
    }
}
