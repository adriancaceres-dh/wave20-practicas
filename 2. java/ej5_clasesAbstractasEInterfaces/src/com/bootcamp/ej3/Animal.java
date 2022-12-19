package com.bootcamp.ej3;

public abstract class Animal {

    protected Class tipo;

    public Animal(Class tipo){
        this.tipo=tipo;
    }

    public Class getTipo(){return tipo;}

    public abstract void emitirSonido();

    public static void comerAnimal(Animal a){
        if(a.getTipo()==Carnivoro.class){
            System.out.println("Comiendo carne");
        }else{
            System.out.println("Comiendo hierba");
        }
    }

}
