package com.bootcamp;

public class PrototypeInteger extends Prototype<Integer>{


    public PrototypeInteger(Integer valorSerie) {
        super(valorSerie);
        valorActual = 0;
        valorInicial = 0;
    }

    @Override
    public Integer valorSiguiente() {
        valorActual = valorActual + valorSerie;
        return valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorInicial = 0;
        valorActual = 0;
    }

    @Override
    public void iniciarSerie(Integer nuevoValorInicial) {
        valorInicial = nuevoValorInicial;
        valorActual = nuevoValorInicial;
    }
}
