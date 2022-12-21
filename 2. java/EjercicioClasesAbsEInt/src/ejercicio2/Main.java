package ejercicio2;

import ejercicio2.clases.Curriculum;
import ejercicio2.clases.Impresora;
import ejercicio2.clases.Informe;
import ejercicio2.clases.LibroPdf;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Informe informe = new Informe("Hola como estas",1,"Ignacio Tornati","Julian Alvarez");
        LibroPdf pdf = new LibroPdf(5,"Julian ALvarez","Masculino","Como ganar un mundial");
        Curriculum curriculum = new Curriculum("Julian","Alvarez","Campeon del mundo");

        Impresora.imprimir(informe);
        Impresora.imprimir(pdf);
        Impresora.imprimir(curriculum);

    }
}
