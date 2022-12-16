package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("José", 22, "38409312", 100.5f, 1.65f);
        System.out.println(persona);
        AgeIndicator.displayIfIsLegalOrNot(persona.esMayorDeEdad());
        WeightLevelIndicator.displayWeightLevelByImcIndex(persona.calcularIMC());
    }

}