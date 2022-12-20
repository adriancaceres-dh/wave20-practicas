package com.bootcamp;

public class SerieIntegerDos extends Prototipo<Integer> {

    public SerieIntegerDos(Integer inicial) {
        super(inicial);
    }

    @Override
    protected Integer valorSiguiente() {
        inicial = inicial + 2;
        return inicial;
    }

    @Override
    protected void reiniciar() {
        inicial = 0;
    }
}
