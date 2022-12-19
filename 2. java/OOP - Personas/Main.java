package com.poo;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Lucas", 23, "52334216");
        Persona persona3 = new Persona("Diego", 10, "10101010" , 70, 170);

        int IMC= persona3.calcularIMC();
        switch (IMC) {
            case -1 -> System.out.println("Bajo peso");
            case 0 -> System.out.println("Peso saludable");
            case 1 -> System.out.println("Sobrepeso");
            default -> System.out.println("Error");
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println("Esta persona es mayor de edad");
            System.out.println("Esta persona es menor de edad");
        }

        System.out.println(persona3);
    }
}
