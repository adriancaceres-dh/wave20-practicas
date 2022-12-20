package com.bootcamp;

public class DoublePrototipo extends Prototipo<Double>{

    public DoublePrototipo(Double numeroSerie) {
        super(numeroSerie);
        numeroActual = 0d;
        numeroInicioSerie = 0d;
    }

    @Override
    public void reiniciarSerie() {
        numeroActual = 0d;
        numeroInicioSerie = 0d;
    }

    @Override
    public void setearValorInicial(Double nuevoValorInicio) {
        numeroInicioSerie = nuevoValorInicio;
        numeroActual = nuevoValorInicio;
    }

    @Override
    public Double obtenerValorSiguiente() {
        numeroActual += numeroSerie;
        return numeroActual;
    }
}
