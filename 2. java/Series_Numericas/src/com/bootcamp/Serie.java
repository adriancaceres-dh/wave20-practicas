package com.bootcamp;

public class Serie extends Prototipo<Integer>{
    public Serie(Integer numero) {
        super(numero);
        inicio = numero;
        actual = numero;
    }
    @Override
    public Integer siguiente() {
        if (actual == 1){
            numero = 2;
            return actual += numero;
        }
        return actual += numero;
    }
    @Override
    public void reiniciar() {
        actual = 0;
        numero = 0;
    }
    @Override
    public void valorInicial(Integer numero) {
        this.numero = numero;
        actual = numero;
    }
}
