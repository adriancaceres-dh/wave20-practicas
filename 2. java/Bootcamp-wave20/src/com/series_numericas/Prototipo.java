package com.series_numericas;

public abstract class Prototipo<T extends Number> {

    protected T valorInicial;

    public abstract T siguiente();

     public abstract String reiniciar();

    public abstract String valorInicial(T valor);



}
