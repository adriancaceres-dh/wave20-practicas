package com.imprenta;

public interface Imprimible<T extends Documento> {

    static void imprimir(Documento documento) {
        System.out.println("Imprimiendo el documento: "+ documento.getNombre());
    };
}
