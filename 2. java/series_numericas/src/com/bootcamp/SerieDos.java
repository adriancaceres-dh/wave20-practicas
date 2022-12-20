package com.bootcamp;

public class SerieDos extends Prototipo<Number> {

    public SerieDos(Number inicial) {
        super(inicial);
    }

    @Override
    protected Number valorSiguiente() {
        inicial = inicial.doubleValue() + 2;
        return inicial;
    }

    @Override
    protected void reiniciar() {
        inicial = 0;
    }
}
