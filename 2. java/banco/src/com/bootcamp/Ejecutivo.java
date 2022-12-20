package com.bootcamp;

public class Ejecutivo implements Deposito,Transferencia{

    public Ejecutivo() {

    }
    public void deposito(){
        System.out.println("realizando deposito");
        transaccionOk();
    }
    public void transferencia(){
        System.out.println("realizando transferencia");
        transaccionNoOk();
    }
}
