package com.bootcamp;

import com.bootcamp.interfaces.ConsultaSaldo;
import com.bootcamp.interfaces.PagoServicio;
import com.bootcamp.interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public void retirarEfectivo() {
        System.out.println("Realizando retiro en efectivo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Realizando pago de servicio");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("realizando consulta de saldo");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transacción "+transaccion+" realizada con éxito");
    }
    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transacción "+transaccion+" intentada sin éxito");
    }
}
