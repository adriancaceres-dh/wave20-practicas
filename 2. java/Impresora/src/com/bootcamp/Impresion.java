package com.bootcamp;

public interface Impresion<T> {
    static <T> void imprimir(T object){
        System.out.println(object);
    };
}
