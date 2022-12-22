package com.distribuidora_excepciones;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {
        try {
          double c =  b/a;
        } catch (ArithmeticException e) {
           throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");

        }
    }
}
