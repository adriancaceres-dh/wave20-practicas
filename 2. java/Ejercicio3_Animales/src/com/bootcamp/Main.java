package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        //Perro
        perro.emitirSonido();
        perro.comerCarne();

        //Gato
        gato.emitirSonido();
        gato.comerCarne();

        //Vaca
        vaca.emitirSonido();
        vaca.comerHierba();

        //Extra
        System.out.println("Extra");
        Animal.comerAnimal(vaca);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(perro);
    }
}
