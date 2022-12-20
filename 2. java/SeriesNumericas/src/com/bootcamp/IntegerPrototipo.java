package com.bootcamp;

public class IntegerPrototipo extends Prototipo<Integer> {

    public IntegerPrototipo(Integer numeroSerie) {
        super(numeroSerie);
        numeroActual = 0;
        numeroInicioSerie = 0;
    }

    @Override
    public void reiniciarSerie() {
        numeroActual = 0;
        numeroInicioSerie = 0;
    }

    @Override
    public void setearValorInicial(Integer nuevoValorInicio) {
        numeroInicioSerie = nuevoValorInicio;
        numeroActual = nuevoValorInicio;
    }

    @Override
    public Integer obtenerValorSiguiente() {
        numeroActual += numeroSerie;
        return numeroActual;
    }
}
