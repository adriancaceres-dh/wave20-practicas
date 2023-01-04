package com.bootcamp;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo, TransaccionNoOk, TransaccionOK{
    @Override
    public void consultarSaldo() {
        double resultado = Math.random();
        System.out.println("Bienvenido cobrador, estamos consultado su sueldo");
        if (resultado >= 0 && resultado <0.5){
            transaccionExitosa();
        } else if(resultado >=0.5) {
            transaccionFallida();
        }
       }

    @Override
    public void retirarEfectivo() {
        double resultado = Math.random();
        System.out.println("Bienvenido cobrador, estamos procesando su retiro de efectivo");
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
