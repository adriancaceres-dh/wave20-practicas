package com.bootcamp;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        LibrosEnPdf libroPdf = new LibrosEnPdf(300, "Kim Harrison", "The good, the bad and the undead", "Paranormal");
        Curriculums curriculum = new Curriculums("Cindy", "40402552", "3513412622", "Software Developer");
        Informes informe = new Informes(5000, 5, "Gerard Way", "Frank Iero");

        String habilidad1 = "Java";
        String habilidad2 = "Javascript";
        String habilidad3 = "Node JS";

        curriculum.agregarHabilidad(habilidad1);
        curriculum.agregarHabilidad(habilidad2);
        curriculum.agregarHabilidad(habilidad3);
        //informe.imprimir();
        curriculum.imprimir();
        //libroPdf.imprimir();
    }
}