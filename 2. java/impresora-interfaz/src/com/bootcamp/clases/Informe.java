package com.bootcamp.clases;

import com.bootcamp.interfaces.IImpresora;

public class Informe implements IImpresora {

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo un informe");
    }
}
