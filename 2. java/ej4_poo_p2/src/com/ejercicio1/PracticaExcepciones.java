package com.ejercicio1;

public class PracticaExcepciones {
    private int a, b;

    public PracticaExcepciones(){
        this.a=0;
        this.b=300;
    }

    public void calcularCociente(){
        try{
            double res=b/a;
            System.out.println("El cociente es: "+res);
        }catch (ArithmeticException err){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
