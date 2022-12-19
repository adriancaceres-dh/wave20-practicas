package com.bootcamp.clases;

import com.bootcamp.interfaces.IImprimible;

public abstract class Documento implements IImprimible {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo contenido...\n");
        System.out.println("CONTENIDO DEL DOCUMENTO:\n");
        System.out.println(toString());
    }
}
