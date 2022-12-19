package com.bootcamp;

import com.bootcamp.clases.Basic;
import com.bootcamp.clases.Cliente;
import com.bootcamp.clases.Cobrador;
import com.bootcamp.clases.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        // Operaciones ejecutivo
        ejecutivo.realizarDeposito(5432.0);
        ejecutivo.realizarTransferencia(0.0);
        System.out.println();

        // Operaciones basic
        basic.realizarPagoDeServicios(0.0);
        basic.realizarConsultaDeSaldo();
        basic.realizarRetiroDeEfectivo(5442.0);
        System.out.println();

        // Operaciones cobrador
        cobrador.realizarConsultaDeSaldo();
        cobrador.realizarRetiroDeEfectivo(0.0);
        System.out.println();
    }
}
