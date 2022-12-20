package com.bootcamp.operaciones;

public class ConsultaSaldo implements TransaccionInterface {

    public void consultarSaldo(int numeroCuenta) {
        //no existen numeros de cuentas negativos
        if (numeroCuenta <= 0) {
            transaccionNoOk();
        } else {
            transaccionOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("La consulta de saldo fue exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo consultar el saldo");
    }
}
