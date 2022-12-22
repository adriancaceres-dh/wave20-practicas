package com.animales;

public class App {

    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println(gato.emitirSonido());
        System.out.println(perro.emitirSonido());
        System.out.println(vaca.emitirSonido());

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerVegetal();



    }
}
