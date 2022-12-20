package com.bootcamp.intefaces;

public interface ITransferencia extends ITransaccion {

    public boolean hacerTransferencia(double monto, String nroCuenta);
}