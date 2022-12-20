package com.bootcamp;

public class Serie3 extends Prototipo <Integer>{
    public Serie3() {
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
        num= num + 3;
        return num;
    }
}
