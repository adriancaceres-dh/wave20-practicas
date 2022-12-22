package com.transacciones_banco;

public interface ITransaccion<T extends ICliente> {

    void transaccionOk(T cliente);
    void transaccionNoOk();

    void aceptar(TransactionVisitor visitor);


}
