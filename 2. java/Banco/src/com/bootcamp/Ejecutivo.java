package com.bootcamp;

import com.bootcamp.interfaces.Deposito;
import com.bootcamp.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando su depósito espere un momento");
        if((int)((Math.random()*2)+1) == 1) transaccionOk("deposito");
        else transaccionNoOk("deposito");
    }

    @Override
    public void transaccionOk(String nombreOperacion) {
        System.out.println(String.format("Su %s ha sido exitoso", nombreOperacion));
    }

    @Override
    public void transaccionNoOk(String nombreOperacion) {
        System.out.println(String.format("Su %s no ha sido exitoso", nombreOperacion));
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando su transferencia espere un momento");
        if((int)((Math.random()*2)+1) == 1) transaccionOk("transferencia");
        else transaccionNoOk("transferencia");
    }
}
