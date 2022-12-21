package com.bootcamp;

public class Basic extends Cliente{

    public void realizarConsultaSaldo() {
        realizarTransaccion(4);
    }

    public void realizarPagoServicio() {
        realizarTransaccion(5);
    }

    public void realizarRetiro() {
        realizarTransaccion(3);
    }
}
