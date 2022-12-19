package com.bootcamp;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;


    public static void coeficiente(int a, int b) {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero.");
            }
            double coeficiente = b / a;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
