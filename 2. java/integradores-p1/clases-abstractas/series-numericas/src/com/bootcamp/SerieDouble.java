package com.bootcamp;

public class SerieDouble extends SeriePrototipo<Double>{

    public SerieDouble(Double inicio, Double step) {
        super(inicio, step);
    }

    @Override
    public void reiniciar() {
        actual = inicio;
    }

    @Override
    public void setInicio(Double nuevoInicio) {
        inicio = nuevoInicio;
    }

    @Override
    public Double siguiente() {
        actual += step;
        return actual;
    }
}