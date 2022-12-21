package com.bootcamp;

public interface iImprimible<T> {

    public static <T> void imprimir(T obj){

        System.out.println("imprimiendo: " + obj.getClass().getSimpleName());



    }

}
