package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        String animal;

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        gato.comer();
        perro.comer();
        vaca.comer();
    }
}