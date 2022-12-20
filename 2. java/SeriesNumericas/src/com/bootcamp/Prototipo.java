package com.bootcamp;

public abstract class Prototipo<T extends Number> {
    protected T numeroSerie;
    protected T numeroInicioSerie;
    protected T numeroActual;

    public Prototipo(T numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public abstract void reiniciarSerie();

    public abstract void setearValorInicial(T nuevoValorInicio);

    public abstract T obtenerValorSiguiente();

}
