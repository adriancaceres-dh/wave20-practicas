package com.bootcamp;

public class Serie3 extends Prototipo <Integer>{
    //Constructor con un valor inicial
    public Serie3() {
        numero = 0;
    }

    @Override
    public Integer valorSiguiente() {
        numero = numero + 3;
        return numero;
    }

    @Override
    public void reiniciarSerie() {
        numero = 0;
    }

    @Override
    public void establecerInicial(Integer inicio) {
        numero = inicio;
    }
}
