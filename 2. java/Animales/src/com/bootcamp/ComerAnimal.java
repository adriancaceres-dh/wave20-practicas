package com.bootcamp;

public interface ComerAnimal<Carnivoro,Hervivoro> {
    static <Carnivoro,Hervivoro> void comerAnimal(Animal animal){
        animal.comer();
    };
}
