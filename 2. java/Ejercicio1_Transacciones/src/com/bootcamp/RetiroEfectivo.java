package com.bootcamp;

public class RetiroEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Dinero retirado de la cuenta");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido completar la extracción");
    }
}
