package com.bootcamp.ej2;

public interface Documento {

    void imprimir();

    static void imprimir(Documento doc){
        doc.imprimir();
    }
}
