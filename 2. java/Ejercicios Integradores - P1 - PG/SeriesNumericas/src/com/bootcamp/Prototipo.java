package com.bootcamp;

public abstract class Prototipo <T>{

    T num;

    public Prototipo() {

    }

    public abstract void reiniciarSerie();
    public abstract void inicializarSerie(T num);
    public abstract T proximoValorSerie();
}
