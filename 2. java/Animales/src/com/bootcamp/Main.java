package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato("Tomas");
        Perro perro = new Perro("Trueno");
        Vaca vaca = new Vaca("Lola");

        System.out.println("GATO");
        gato.comer();
        gato.sonido();
        System.out.println("PERRO");
        perro.comer();
        perro.sonido();
        System.out.println("VACA");
        vaca.comer();
        vaca.sonido();
        System.out.println("PRUEBA METODO ESTATICO");
        Animal.comerAnimal(perro);
        Animal.comerAnimal(vaca);
    }
}