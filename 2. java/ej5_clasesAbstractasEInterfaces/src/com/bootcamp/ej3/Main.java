package com.bootcamp.ej3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Animal[] animales = {new Gato(),new Perro(), new Vaca()};

        Arrays.stream(animales).forEach(animal->{
            animal.emitirSonido();
            Animal.comerAnimal(animal);
        });


    }
}
