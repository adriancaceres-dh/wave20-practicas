package com.bootcamp;

import com.bootcamp.clases.*;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Cindy", "40402552", "3523412622");
        Tutor tutor1 = new Tutor("Jill", "36662517", "3513412622");

        String curso1 = "Java";
        String curso2 = "Lenguajes y automatas";
        estudiante1.agregarCurso(curso1);
        estudiante1.agregarCurso(curso2);

        estudiante1.aprendo();


        String materiaCursando1 = "Ingeniería de software III";
        // el método agregarCurso lo hereda de la clase estudiante
        tutor1.agregarCurso(materiaCursando1);

        String cursoAEnseniar1 = "Fisica III";
        String cursoAEnseniar2 = "Analisis matemático III";
        tutor1.cursosAEnseniar(cursoAEnseniar1);
        tutor1.cursosAEnseniar(cursoAEnseniar2);

        tutor1.ensenio();
    }
}