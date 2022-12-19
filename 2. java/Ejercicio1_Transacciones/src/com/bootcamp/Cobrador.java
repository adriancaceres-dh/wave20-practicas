package com.bootcamp;

public class Cobrador {
    public void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        System.out.println("Consultando saldo...");
        consultaSaldo.transaccionOk(); //o transaccionNoOk();
    }

    public void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        System.out.println("Retirando efectivo...");
        retiroEfectivo.transaccionOk();
    }
}
