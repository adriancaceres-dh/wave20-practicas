package com.bootcamp;

public class SerieShortTres extends Prototipo<Short> {

    public SerieShortTres(Short inicial) {
        super(inicial);
    }

    @Override
    protected Short valorSiguiente() {
        inicial = (short)(inicial + 3);
        return inicial;
    }

    @Override
    protected void reiniciar() {
        inicial = 0;
    }
}
