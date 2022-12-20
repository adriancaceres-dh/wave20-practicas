package com.bootcamp;

public abstract class Prototipo<T> {

    T inicial;

    public Prototipo(T inicial) {
        this.inicial = inicial;
    }

    protected abstract T valorSiguiente();

    protected abstract void reiniciar();

    public void asignarValorInicial(T valor) {
        inicial = valor;
    }
}
