package com.bootcamp;

public class SerieInteger extends SeriePrototipo<Integer>{

    public SerieInteger(Integer inicio, Integer step) {
        super(inicio, step);
    }

    @Override
    public void reiniciar() {
        actual = inicio;
    }

    @Override
    public void setInicio(Integer nuevoInicio) {
        inicio = nuevoInicio;
    }

    @Override
    public Integer siguiente() {
        actual += step;
        return actual;
    }
}
