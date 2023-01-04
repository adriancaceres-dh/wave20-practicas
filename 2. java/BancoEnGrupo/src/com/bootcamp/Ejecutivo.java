package com.bootcamp;

public class Ejecutivo {

    public void realizarDeposito() {
        ITransaccion deposito = new Deposito();
        System.out.println("Realizandose depósito");
    }
}
