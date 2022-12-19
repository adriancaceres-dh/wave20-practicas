package com.bootcamp;

public class PracticaExcepciones {
    int a;
    int b;
    public PracticaExcepciones() {
        a = 0;
        b = 300;
    }

    public int calcularCociente() {
        int salida = 1;
        try {
            if(a==0) throw new IllegalArgumentException("No se puede dividir por cero");
            salida = b/a;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
        return salida;
    }
}
