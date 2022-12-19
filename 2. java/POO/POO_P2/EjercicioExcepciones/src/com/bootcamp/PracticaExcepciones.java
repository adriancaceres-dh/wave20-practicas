package com.bootcamp;

public class PracticaExcepciones {


    public static void main(String[] args) {

        int a = 0, b = 300;

        // PARTE 1

        try {
            float c = b/a;
        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }finally{
            System.out.println("Programa Finalizado");
        }
        System.out.println("------------------------");
        // PARTE 2
        try {
            double c = division (b,a);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }finally{
            System.out.println("Programa Finalizado");
        }
    }
    public static double division(int num, int div){
        if (div==0) throw new IllegalArgumentException("Divisor debe ser mayor que 0");
        return num/div;
    }
}
