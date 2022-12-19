package com.bootcamp;

public class Basic {
    public void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        System.out.println("Consultando saldo...");
        consultaSaldo.transaccionOk(); //o transaccionNoOk();
    }

    public void pagarServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        System.out.println("Pagando servicio...");
        pagoServicios.transaccionOk();
    }

    public void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        System.out.println("Retirando efectivo...");
        retiroEfectivo.transaccionOk();
    }
}
