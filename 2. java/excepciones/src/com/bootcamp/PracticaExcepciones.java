package com.bootcamp;

public class PracticaExcepciones {
    private final int a;
    private final int b;

    public PracticaExcepciones() {
        a = 0;
        b = 300;
    }

    public int calcularCociente() {
        try {
            return b/a;
        } catch (ArithmeticException a) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}