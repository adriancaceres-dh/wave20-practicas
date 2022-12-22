package com.bootcamp;

public class PracticaExcepciones {

    public static int a = 0;
    public static int b = 300;
    public static void cociente() {
        /*
        try{
            double resultado = b / a;
        }catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }
        */

        try{
            throw new IllegalArgumentException("No se puede dividir por cero");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }

    }

    public static void main(String[] args) {
        cociente();
    }

}
