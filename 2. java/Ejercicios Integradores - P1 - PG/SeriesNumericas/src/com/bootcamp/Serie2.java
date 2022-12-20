package com.bootcamp;

public class Serie2 extends Prototipo <Integer>{

    public Serie2() {
        num = 0;
    }

    @Override
    public void reiniciarSerie() {
        num = 0;
    }

    @Override
    public void inicializarSerie(Integer num) {
        this.num = num;
    }

    @Override
    public Integer proximoValorSerie() {
        num= num + 2;
        return num;
    }

}
