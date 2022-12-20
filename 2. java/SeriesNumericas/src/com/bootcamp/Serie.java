package com.bootcamp;

public class Serie<T extends Number> extends Prototipo<T >{
    private T valorInicial;
    private double ultimoValor;

    public Serie(T valorInicial) {
        this.valorInicial = valorInicial;
        this.ultimoValor =valorInicial.doubleValue();
    }

    @Override
    public double valorSiguiente() {
        double valorRetorno=ultimoValor;

        ultimoValor=ultimoValor*valorInicial.doubleValue();
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
