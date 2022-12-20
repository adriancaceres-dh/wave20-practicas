package com.bootcamp.ejercicio1;

public class App {

    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            System.out.println(practicaExcepciones.getB()/ practicaExcepciones.getA());
        } catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
    }

}
