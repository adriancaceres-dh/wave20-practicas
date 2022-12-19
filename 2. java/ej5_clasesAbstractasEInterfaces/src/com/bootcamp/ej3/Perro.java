package com.bootcamp.ej3;

public class Perro extends Animal implements Carnivoro{

    public Perro(){
        super(Carnivoro.class);
    }

    @Override
    public void emitirSonido() {System.out.println("Guau");}

    @Override
    public void comerCarne() {Animal.comerAnimal(this);}

}
