package com.bootcamp;

public class Serie2 extends Prototipo <Integer>{
    //Constructor con un valor inicial
    public Serie2() {
        numero = 0;
    }

    //Al ser una serie de dos, le voy sumando 2
    @Override
    public Integer valorSiguiente() {
        numero = numero + 2;
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
