package com.bootcamp;

public class SerieTres extends Prototipo<Number> {

    public SerieTres(Number inicial) {
        super(inicial);
    }

    @Override
    protected Number valorSiguiente() {
        inicial = inicial.doubleValue() + 3;
        return inicial;
    }

    @Override
    protected void reiniciar() {
        inicial = 0;
    }
}
