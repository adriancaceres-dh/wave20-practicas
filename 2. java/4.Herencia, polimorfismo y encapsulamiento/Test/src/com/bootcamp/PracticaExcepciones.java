package com.bootcamp;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int c = 0;
        /*try{
            c = b/a;
        }catch (Exception e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }*/
        try {
            c = b / a;
        } catch (IllegalArgumentException e) {
            System.out.println("No se puede dividir por cero");
        }
    }
}
