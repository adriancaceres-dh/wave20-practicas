package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona_0 = new Persona();
        Persona persona_1 = new Persona("Juan", 30, "dni");
        Persona persona_2 = new Persona("Juan", 30, "dni", 70.8, 1.83);
        int imc = persona_2.calcularIMC();
        System.out.println(imc);
    }
}