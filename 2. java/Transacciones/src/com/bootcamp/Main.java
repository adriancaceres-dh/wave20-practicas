package com.bootcamp;

import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args){
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        basic.consultaDeSaldo();
        basic.pagoServicios();
        basic.retiroDeEfecitvo();

        cobrador.retiroDeEfecitvo();
        cobrador.consultaDeSaldo();
    }
}
