package com.imprenta;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
       Documento informe = new Informe("Informe", 100, 50, "karen", "kar");
       Documento pdf = new LibroPDF("Libro PDF", 10, "Libro", "Garcia Marquez");
       List<String> habilidades =  new ArrayList<>();
       habilidades.add("Empatía");
       habilidades.add("Sociabilizacion");
       Documento curriculum = new Curriculum("Curriculum", "34567654", "4556433", habilidades);

       Imprimible.imprimir(informe);
       Imprimible.imprimir(pdf);
       Imprimible.imprimir(curriculum);
    }
}
