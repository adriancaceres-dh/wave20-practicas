package com.bootcamp;

public interface IImprimible {
    public void imprimirse();

    public static void imprimir(IImprimible imprimible){
        imprimible.imprimirse();
    }
}
