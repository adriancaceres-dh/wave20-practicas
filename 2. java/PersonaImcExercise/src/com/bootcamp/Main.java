package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("José", 22, "38409312", 100.5f, 1.65f);
        System.out.println(persona);
        System.out.println("La persona: " + decirSiEsMayorDeEdad(persona.esMayorDeEdad()));
        System.out.println("La persona tiene: " + decirNivelDePeso(persona.calcularIMC()));
    }

    private static String decirSiEsMayorDeEdad(boolean esMayorDeEdad) {
        if (esMayorDeEdad) {
            return "Es mayor de edad";
        }
        return "No es mayor de edad";
    }

    private static String decirNivelDePeso(int imc) {
        String nivelDePeso;
        switch (imc) {
            case -1:
                nivelDePeso = "Bajo peso";
                break;
            case 0:
                nivelDePeso = "Peso saludable";
                break;
            case 1:
                nivelDePeso = "Sobrepeso";
                break;
            default:
                nivelDePeso = "No definido";
        }
        return nivelDePeso;
    }

}