package com.bootcamp;

public class PracticaExcepciones {
    private int a,b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void calcularCociente(){
        try{
            double division=b/a;

        }catch (ArithmeticException exception){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
