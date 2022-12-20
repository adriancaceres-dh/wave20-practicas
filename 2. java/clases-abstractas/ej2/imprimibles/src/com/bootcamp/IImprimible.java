package com.bootcamp;

public interface IImprimible {

    static <T> void imprimir(T i) {
        System.out.println("Imprimiendo " + i);
    }
}
