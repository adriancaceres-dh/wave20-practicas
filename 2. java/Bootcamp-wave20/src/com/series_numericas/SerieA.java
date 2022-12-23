package com.series_numericas;

public class SerieA extends Prototipo {


    @Override
    public Number siguiente() {

        double resultado = this.valorInicial.doubleValue() + 2;
        this.valorInicial = resultado;
        return resultado;
    }

    @Override
    public String reiniciar() {
        super.valorInicial = 0;
        return "Serie reiniciada";
    }

    @Override
    public String valorInicial(Number valor) {

        super.valorInicial = valor;
        return "Serie inicializada";
    }
}
