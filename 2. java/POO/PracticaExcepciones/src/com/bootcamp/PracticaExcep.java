package com.bootcamp;

public class PracticaExcep {

    final int a=0;
    final int b=300;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public PracticaExcep() {
    }

    public int Cociente() {
        try{
            int resultado = this.b/this.a;
            return resultado;
        } catch (ArithmeticException ex)  {
            System.out.println("Se ha producido un error :" + ex);
        }

        return 0;
    }
}
