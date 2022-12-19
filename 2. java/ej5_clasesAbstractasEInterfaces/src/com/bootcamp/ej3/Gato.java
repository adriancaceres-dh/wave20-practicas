package com.bootcamp.ej3;

public class Gato extends Animal implements Carnivoro{

    public Gato(){
        super(Carnivoro.class);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        Animal.comerAnimal(this);
    }
}
