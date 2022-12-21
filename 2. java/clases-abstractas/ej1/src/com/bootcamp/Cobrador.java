package com.bootcamp;

public class Cobrador extends Cliente{

    public void realizarRetiro() {
        realizarTransaccion(3);
    }

    public void realizarConsultaSaldo() {
        realizarTransaccion(4);
    }
}
