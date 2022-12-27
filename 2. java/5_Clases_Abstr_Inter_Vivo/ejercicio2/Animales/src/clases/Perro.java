package clases;

import interfaces.iCarnivoro;

public class Perro extends Animal implements iCarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau guau Rrrrrr");
    }

    public void comer () {
        iCarnivoro.comerCarne();
    }
}
