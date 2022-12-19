package com.bootcamp;

public class App {
    public static void main(String[] args) {
        Perro perro=new Perro();
        Gato gato=new Gato();
        Vaca vaca=new Vaca();

        perro.emitirSonido();
        perro.comer();
        gato.emitirSonido();
        gato.comer();
        vaca.emitirSonido();
        vaca.comer();
    }
}
