package com.bootcamp;

import com.bootcamp.modelos.Gato;
import com.bootcamp.modelos.Perro;
import com.bootcamp.modelos.Vaca;

public class Zoologico {

    public static void main(String[] args) {
        Perro toby = new Perro("Toby",5, "Corgi");
        System.out.println(toby.emitirSonido());
        System.out.println(toby.comerCarne());

        Gato raul = new Gato("Raul", 2, "Persa");
        System.out.println(raul.emitirSonido());
        System.out.println(raul.comerCarne());

        Vaca lola = new Vaca("Lola",10);
        System.out.println(lola.emitirSonido());
        System.out.println(lola.comerHierba());
    }
}
