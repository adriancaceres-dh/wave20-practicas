package com.bootcamp;

public class Ejecutivos implements Deposito, Transferencia, TransaccionOK, TransaccionNoOk {

    @Override
    public void depositar() {
        double resultado = Math.random();
        System.out.println("Bienvenido ejectivo, estamos realizando su deposito");
        if (resultado >= 0 && resultado <0.5){
            transaccionExitosa();
        } else if(resultado >=0.5) {
            transaccionFallida();
        }
    }

    @Override
    public void transferir() {
        double resultado = Math.random();
        System.out.println("Bienvenido ejecutivo, estamos realizando su transferencia");
        if (resultado >= 0 && resultado <0.5){
            transaccionExitosa();
        } else if(resultado >=0.5) {
            transaccionFallida();
        }
    }

    @Override
    public void transaccionFallida() {
        System.out.println("La transacción no pudo realizarse con éxito");
    }

    @Override
    public void transaccionExitosa() {
        System.out.println("La transaccion fue exitosa");
    }
}
