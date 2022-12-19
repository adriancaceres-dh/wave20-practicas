package com.bootcamp;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int calcular() {
        int resultado;
        try {
            resultado = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return resultado;
    }
}
