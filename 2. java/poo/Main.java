package com.bootcamp.poo;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Manuel", "1099", 21);
        Persona persona3 = new Persona("Sebastian", "1094", 25, 65, 1.85);

        double imc = persona3.calcularIMC();
        if (imc == -1) System.out.println(persona3.getNombre() + " tiene Bajo peso");
        if (imc == 0) System.out.println(persona3.getNombre() + " tiene Peso saludable");
        if (imc == 1) System.out.println(persona3.getNombre() + " tiene Sobrepeso");

        boolean mayorDeEdad = persona3.esMayorDeEdad();
        System.out.println(persona3.getNombre() + " es mayor? " + mayorDeEdad);

        System.out.println(persona3.toString());
    }
}
