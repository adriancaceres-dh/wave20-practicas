package com.bootcamp;

public class PracticaExepciones {

    private int divisor = 0;
    private int dividendo = 300;

    public void calcularDivision () {
        try {
            double resultado = this.dividendo/this.divisor;
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
