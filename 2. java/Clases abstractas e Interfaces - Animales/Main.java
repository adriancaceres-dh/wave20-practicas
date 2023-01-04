package com.bootcamp;

import com.bootcamp.clases.Gato;
import com.bootcamp.clases.Perro;
import com.bootcamp.clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();
        gato.emitirSonido();
        System.out.println(gato.comerCarne());
        vaca.emitirSonido();
        System.out.println(vaca.comerPlanta());
        perro.emitirSonido();
        System.out.println(perro.comerCarne());
    }
}