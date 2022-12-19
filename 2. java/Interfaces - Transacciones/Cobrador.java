package com.bootcamp;

import com.bootcamp.interfaces.IConsultaSaldo;
import com.bootcamp.interfaces.IRetiroEfectivo;

public class Cobrador implements IRetiroEfectivo, IConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo....");
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Intentando retirar: " + monto);
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }
}
