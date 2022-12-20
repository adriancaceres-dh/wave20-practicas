package com.bootcamp;

public abstract class Prototipo <T> {
    public T numero;

    public Prototipo() {
    }

    //Métodos:
    public abstract T valorSiguiente();
    public abstract void reiniciarSerie();
    public abstract void establecerInicial(T inicio);

}
