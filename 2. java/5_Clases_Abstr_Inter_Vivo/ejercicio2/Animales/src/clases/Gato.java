package clases;

import interfaces.iCarnivoro;

public class Gato extends Animal implements iCarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miau Miau");
    }

    public void comer () {
        iCarnivoro.comerCarne();
    }
}
