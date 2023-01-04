package com.bootcamp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Raul Alejandro", 33);
        Curriculum curriculum = new Curriculum(persona, Arrays.asList("Proactivo", "Bueno con c#"));
        Informe informe = new Informe(10, "Paez Vilaro", "Los beneficios del peso muerto", "Gardel");
        Libro libro = new Libro(240, "Messi", "La pelota y yo", "Futbol");

        Impresora impresora = new Impresora();

        impresora.imprimirDocumento(curriculum);
        impresora.imprimirDocumento(informe);
        impresora.imprimirDocumento(libro);
    }
}