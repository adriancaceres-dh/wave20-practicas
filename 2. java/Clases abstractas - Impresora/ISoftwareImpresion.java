package com.bootcamp;

public interface ISoftwareImpresion {
    default <T> void imprimirDocumento(T obj) {
        System.out.println(obj.toString());
    }
}
