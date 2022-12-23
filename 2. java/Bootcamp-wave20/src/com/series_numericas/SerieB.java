package com.series_numericas;

public class SerieB extends Prototipo {
    @Override
    public Number siguiente() {
        double resultado = this.valorInicial.doubleValue() + 3;
        this.valorInicial = resultado;
        return resultado;
    }

    @Override
    public String reiniciar() {
        this.valorInicial = 0;
        return "Serie reiniciada";
    }

    @Override
    public String valorInicial(Number valor) {
        super.valorInicial = valor;
        return "Serie inicializada";
    }
}
