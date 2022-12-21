package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Persona persona = new Persona("Ivan", 20, "11111111");
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Programar");

        Curriculum curriculum = new Curriculum(persona, habilidades);
        LibroPDF libroPDF = new LibroPDF(100, "Tobias", "La aventura", "Ciencia ficcion");
        Informes informes = new Informes("Texto...", 50, "Autor", "Revisor");

        IImprimible.imprimir(curriculum);
        System.out.println();
        IImprimible.imprimir(libroPDF);
        System.out.println();
        IImprimible.imprimir(informes);

    }
}
