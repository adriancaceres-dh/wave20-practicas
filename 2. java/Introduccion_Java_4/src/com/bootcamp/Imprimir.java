package com.bootcamp;

public interface Imprimir <T>{
    static <T> void imprimir(T objeto){
        System.out.println("Se imprime " + objeto);
    };
}
