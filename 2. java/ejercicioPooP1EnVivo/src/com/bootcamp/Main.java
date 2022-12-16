package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Lorenzo","37290474",29);
        Persona persona3 = new Persona("Lorenzo","37290474",29,1.78,91.5);
        // Persona persona4 = new Persona("Lorenzo", 29);

        if (persona3.esMayorDeEdad()) {
            System.out.println(persona3.getNombre() + " es mayor de edad");
        } else {
            System.out.println(persona3.getNombre() + " es menor de edad");
        }

        switch (persona3.calcularIMC()) {
            case -1:
                System.out.println("Tiene un IMC con: Bajo peso");
                break;
            case 0:
                System.out.println("Tiene un IMC con: Peso saludable");
                break;
            case 1:
                System.out.println("Tiene un IMC con: Sobrepeso");
                break;
        }

        System.out.println(persona3.toString());
    }
}
