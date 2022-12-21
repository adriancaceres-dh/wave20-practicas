package com.bootcamp;

public class Ejecutivo {

    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo(){
        deposito = new Deposito();
        transferencia = new Transferencia();
    }
    public void realizarDeposito(){
        this.deposito.transaccionOk();
    }

    public void realizarTransferencia(){
        this.transferencia.transaccionOk();
    }
}
