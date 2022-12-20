package com.bootcamp.operaciones;

public class RetiroEfectivo implements TransaccionInterface {

    public void retirar(int cantidad) {
        if(cantidad <= 0) {
            transaccionNoOk();
        } else {
            transaccionOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Se ha retirado efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo retirar efectivo de su cuenta");
    }
}
