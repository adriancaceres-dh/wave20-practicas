package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Persona carlos = new Persona("Carlitos", "23", "442252562", "Lavalleja 1453", "Repositor");
        List<String> habilidades = new ArrayList<String>();
        habilidades.add("Comprometido");
        habilidades.add("Perseverante");
        habilidades.add("Buen compañero");
        Curriculum curriculum = new Curriculum(carlos, habilidades);

        IImprimible.imprimir(curriculum);

        Libro libro = new Libro(45, "Laura Segura", "Cómo evitar accidentes en la fábrica", "Autoayuda");

        IImprimible.imprimir(libro);

        Informe informe = new Informe(1056, 130, "Emilce Anónima", "Lautaro González");

        IImprimible.imprimir(informe);
    }
}