package com.bootcamp;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a=0;
        int b=300;
        try{
            int cociente = b/a;
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("El programa ha finalizado");
        }
    }
}