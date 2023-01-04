package com.bootcamp;

import com.bootcamp.interfaces.IDeposito;
import com.bootcamp.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Intentando hacer depósito...");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");
    }
}
