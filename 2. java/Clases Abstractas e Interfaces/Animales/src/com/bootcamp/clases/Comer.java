package com.bootcamp.clases;

import com.bootcamp.clases.Gato;
import com.bootcamp.clases.Perro;
import com.bootcamp.clases.Vaca;

public class Comer {
    public static void comerAnimal(Animal animal){
        if (animal instanceof Perro){
            ((Perro) animal).comerCarne();
        }else if (animal instanceof Vaca){
            ((Vaca) animal).comerHierba();
        } else if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        }
    }
}
