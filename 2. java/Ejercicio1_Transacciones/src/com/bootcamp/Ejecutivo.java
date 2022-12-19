package com.bootcamp;

public class Ejecutivo {
    public void realizarDeposito(){
        Deposito deposito = new Deposito();
        System.out.println("Realizando deposito...");
        deposito.transaccionOk(); //o transaccionNoOk(), depende del resultado que se obtiene
    }

    public void realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        System.out.println("Realizando transferencia...");
        transferencia.transaccionOk();
    }
}
