package com.bootcamp;

public abstract class Animal {
    public abstract void emitirSonido();

    public static void comerAnimal(Animal animal){
        if(animal instanceof Vaca) ((Vaca) animal).comerHierba();
        else if (animal instanceof Gato || animal instanceof Perro) ((ICarnivoro) animal).comerCarne();
    }
}
