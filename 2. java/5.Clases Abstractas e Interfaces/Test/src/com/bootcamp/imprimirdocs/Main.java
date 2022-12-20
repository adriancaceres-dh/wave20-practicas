package com.bootcamp.imprimirdocs;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona("Nathalia", 20, Arrays.asList("Ágil", "Creativa"));
        Curriculums curriculums = new Curriculums(persona);
        PdfDocs pdfDocs = new PdfDocs(100, "Antonio", "Laberinto del fauno", "Suspenso");
        Informs informs = new Informs(100, "Antonio", "Laberinto del fauno", "Augusto");
        Impresora impresora = new Impresora();
        impresora.printDoc(curriculums);
        impresora.printDoc(pdfDocs);
        impresora.printDoc(informs);
    }


}
