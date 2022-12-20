package com.bootcamp.ej_clases_abstractas;

public abstract class Prototipo <T extends Number>{

    protected final T numero_serie;
    protected T valor_actual;

    protected Prototipo(T numero_serie, T valor_actual) {
        this.numero_serie = numero_serie;
        this.valor_actual = valor_actual;
    }

    public abstract T devolverSiguiente();

    public abstract void reiniciarSerie();

    public abstract void establecerValorInicial(T valor);


}
