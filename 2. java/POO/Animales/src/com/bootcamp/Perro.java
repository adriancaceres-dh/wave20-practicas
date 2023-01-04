package com.bootcamp;

public class Perro extends Animal implements IComerCarne{
    @Override
    void emitirSonido() {
        System.out.println("Guau!");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perrito carnivoro");
    }

}
