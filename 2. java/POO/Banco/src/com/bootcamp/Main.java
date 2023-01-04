package com.bootcamp;

public class Main {
    public static void main(String[] args) {

        Ejecutivos ejecutivo = new Ejecutivos();
        Basic clienteBasic = new Basic();
        Cobradores cobrador = new Cobradores();

        /*******EJECUTIVO*****/
       // ejecutivo.depositar();
        ejecutivo.transferir();

        /*******CLIENTE BASIC*****/
        clienteBasic.consultarSaldo();
       // clienteBasic.pagarServicio();
       // clienteBasic.retirarEfectivo();

        /*******COBRADOR*****/
        cobrador.retirarEfectivo();
       // cobrador.consultarSaldo();


    }
}