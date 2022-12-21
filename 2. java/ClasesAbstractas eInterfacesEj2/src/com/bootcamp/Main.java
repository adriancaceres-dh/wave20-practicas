package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String>listaHabilidades = new ArrayList<>();
        listaHabilidades.add("Veloz");
        listaHabilidades.add("Inteligente");
        Curriculum curriculum = new Curriculum("x,y,z", listaHabilidades);
        LibrosPDF libroPDF = new LibrosPDF(5,"Diego","Meli bootcamp", "Aventura");

        iImprimible.imprimir(curriculum);
        iImprimible.imprimir(libroPDF);



    }

}