package com.bootcamp;

public class Serie2<T extends Number> extends Prototipo<T >{
    private T valorInicial;
    private double ultimoValor;

    public Serie2(T valorInicial) {
        this.valorInicial = valorInicial;
        this.ultimoValor =valorInicial.doubleValue();
    }

    @Override
    public double valorSiguiente() {
        double valorRetorno=ultimoValor;

        ultimoValor=ultimoValor+2;
        return valorRetorno;
    }

    @Override
    public void reiniciarSerie() {
        ultimoValor=valorInicial.doubleValue();
    }

    @Override
    public void valorInicial(T value) {
        valorInicial=value;
        reiniciarSerie();
    }

}
