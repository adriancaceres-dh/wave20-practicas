package com.bootcamp;

public class WeightLevelIndicator {

    static void displayWeightLevelByImcIndex(int imcIndex) {
        String nivelDePeso;
        switch (imcIndex) {
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
        System.out.println("El nivel de peso es: " + nivelDePeso);
    }
}
