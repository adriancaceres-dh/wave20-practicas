package com.bootcamp;

import com.bootcamp.interfaces.ConsultaSaldo;
import com.bootcamp.interfaces.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {

    @Override
    public void retirarEfectivo() {
        System.out.println("Realizando retiro en efectivo");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Realizando consulta de Saldo");
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
