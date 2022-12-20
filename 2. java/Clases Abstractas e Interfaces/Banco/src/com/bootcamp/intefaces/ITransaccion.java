package com.bootcamp.intefaces;

public interface ITransaccion {

    public void transaccionOk(String tipoTransaccion);
    public void transaccionNoOk(String tipoTransaccion);
}
