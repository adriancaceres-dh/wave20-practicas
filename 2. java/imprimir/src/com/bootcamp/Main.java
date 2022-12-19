package com.bootcamp;

import com.bootcamp.clases.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Documento curriculum = new Curriculum(
                new Persona("Javier Jiménez", 'M', 23),
                Arrays.asList("Programación", "Inglés", "Deporte")
        );
        Documento libro = new LibroPDF(
                320,
                new Persona("Fatima Robles", 'F', 24),
                "Libro del futuro",
                "Tecnología"
        );
        Documento informe = new Informe(
                "Este es el texto del informe. Aquí se informan muchas cosas.",
                5,
                new Persona("Julio Gómez", 'M', 43),
                new Persona("Paulina Martínez", 'F', 54)
        );

        // Imprimir los documentos
        curriculum.imprimir();
        System.out.println();

        libro.imprimir();
        System.out.println();

        informe.imprimir();
        System.out.println();
    }
}
