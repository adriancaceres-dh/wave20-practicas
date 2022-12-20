package com.bootcamp.animals;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        gato.sonidoAnimal();
        System.out.println(gato.comeCarne());
        vaca.sonidoAnimal();
        System.out.println(vaca.comeHierba());
        perro.sonidoAnimal();
        System.out.println(perro.comeCarne());
    }
}
