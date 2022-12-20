package com.bootcamp;

import com.bootcamp.clases.Basic;
import com.bootcamp.clases.Cliente;
import com.bootcamp.clases.Cobrador;
import com.bootcamp.clases.Ejecutivo;

public class Banco {

    public static void main(String[] args) {
        System.out.println("-----BANCO-----");
        Basic basic = new Basic("Juan", 20000.0);
        Cobrador cobrador = new Cobrador("Carlos", 30000.0);
        Ejecutivo ejecutivo = new Ejecutivo("Manuel", 50000.0);
        basic.hacerConsultaSaldo();
        if(basic.hacerRetiroEfectivo(18000)){
            basic.transaccionOk("Retiro de efectivo");
        }else{
            basic.transaccionNoOk("Retiro de efectivo");
        }

        if(basic.hacerPagoServicios("ANTEL", 3500)){
            basic.transaccionOk("Pago de servicio de ANTEL");
        }else{
            basic.transaccionNoOk("Pago de servicio de ANTEL");
        }

        cobrador.hacerConsultaSaldo();

        if(cobrador.hacerRetiroEfectivo(15000)){
            basic.transaccionOk("Retiro de efectivo");
        }else{
            basic.transaccionNoOk("Retiro de efectivo");
        }

        ejecutivo.hacerDeposito(30000);
        if(ejecutivo.hacerTransferencia(40000, "4785695631")){
            basic.transaccionOk("Transferencia");
        }else{
            basic.transaccionNoOk("Transferencia");
        }

    }
}
