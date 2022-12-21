package com.bootcamp;

public abstract class SeriePrototipo<T extends Number> {
    protected T inicio;
    protected T step;
    protected T actual;

    public SeriePrototipo(T inicio, T step) {
        this.inicio = inicio;
        this.step = step;
        this.actual = inicio;
    }

    public abstract void reiniciar();

    public abstract void setInicio(T nuevoInicio);

    public abstract T siguiente();

}
