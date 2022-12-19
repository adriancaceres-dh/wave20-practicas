package com.bootcamp;

import com.bootcamp.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Prueba de curriculum
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Python");
        habilidades.add("Java");
        Curriculum curriculoPrueba = new Curriculum("Sergio Machado", "333333333", "3 años",
                "a@a.com", habilidades);
        Imprimible.imprimir(curriculoPrueba);

        //Prueba de informe
        Informes informePrueba = new Informes("Daniel Lopez", "Rodrigo Martinez",350,"Muy largo");
        Imprimible.imprimir(informePrueba);

        //Prueba Libro PDF

        LibroPDF libroPrueba = new LibroPDF("100 años de soledad","Gabriel Garcia Marquez",223,"Realismo Fantástico");
        Imprimible.imprimir(libroPrueba);
    }
}