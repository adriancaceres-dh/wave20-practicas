package com.bootcamp.ej3;

public class Vaca extends Animal implements Herviboro{

    public Vaca(){
        super(Herviboro.class);
    }

    @Override
    public void emitirSonido() {System.out.println("Muuu");}

    @Override
    public void comerHierba() {Animal.comerAnimal(this);}
}
