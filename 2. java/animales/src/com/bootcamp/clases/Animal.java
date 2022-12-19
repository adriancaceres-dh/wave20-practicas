package com.bootcamp.clases;

public abstract class Animal {
    private String tipo;

    public Animal(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract void emitirSonido();
}
