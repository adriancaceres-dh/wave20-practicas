package com.bootcamp;

public class Ejecutivos implements Deposito,Transferencia{


    @Override
    public void realizarDeposito(double monto) {
        System.out.println("Se realizó el depósito de $" + monto);
    }

    @Override
    public void trasaccionOk(String transaccion) {
        System.out.println(transaccion + " exitoso");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println(transaccion + " falló");
    }

    @Override
    public void RealizarTrasferencia(double monto) {
        System.out.println("Se realizó la transferencia de $" + monto);

    }
}
