package com.bootcamp.clases;

public class Cobrador extends Cliente {
    public void realizarConsultaDeSaldo() {
        realizarTransaccion(new ConsultaDeSaldo());
    }

    public void realizarRetiroDeEfectivo(double saldo) {
        if(saldo > 0.0) realizarTransaccion(new RetiroDeEfectivo());
        else            realizarTransaccionErronea(new RetiroDeEfectivo());
    }
}
