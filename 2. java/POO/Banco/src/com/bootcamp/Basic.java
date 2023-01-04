package com.bootcamp;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo, TransaccionOK, TransaccionNoOk{

    @Override
    public void consultarSaldo() {
        double resultado = Math.random();
        System.out.println("Bienvenido cliente, estamos consultado su saldo");
        if (resultado >= 0 && resultado <0.5){
            transaccionExitosa();
        } else if(resultado >=0.5) {
            transaccionFallida();
        }
     }

    @Override
    public void pagarServicio() {
        double resultado = Math.random();
        System.out.println("Bienvenido cliente, estamos pagando el servicio");
        if (resultado >= 0 && resultado <0.5){
            transaccionExitosa();
        } else if(resultado >=0.5) {
            transaccionFallida();
        }
      }

    @Override
    public void retirarEfectivo() {
        double resultado = Math.random();
        System.out.println("Bienvenido cliente, estamos retirando su efectivo");
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
