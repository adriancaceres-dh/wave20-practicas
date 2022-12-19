package com.bootcamp.ej2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Documento[] docs = {new Informe(),new Curriculum(),new PDF()};

        Arrays.stream(docs).forEach(doc->Documento.imprimir(doc));

    }
}
