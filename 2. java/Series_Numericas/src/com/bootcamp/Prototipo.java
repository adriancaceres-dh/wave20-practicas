package com.bootcamp;

public abstract class Prototipo <T extends Number> {
    protected T numero;
    protected T inicio;
    protected T actual;

    public Prototipo(T numero) {
        this.numero = numero;
    }

    public abstract T siguiente();

    public abstract void reiniciar();

    public abstract void valorInicial(T numero);
}
