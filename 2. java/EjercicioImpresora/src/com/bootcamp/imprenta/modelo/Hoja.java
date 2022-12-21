package com.bootcamp.imprenta.modelo;

public abstract class Hoja{

    protected String contenido;

    public Hoja(String contenido) {
        this.contenido = contenido;
    }

    abstract public String imprimir();
}
