package com.bootcamp;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones() {
        a = 0;
        b = 300;
    }

    public double calcularCociente() {
        try {
            if(a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

            return b/a;
        } catch (ArithmeticException a) {
            System.out.println("Se ha producido un error: " + a.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }
}
