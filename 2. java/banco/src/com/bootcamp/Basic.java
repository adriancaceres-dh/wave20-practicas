package com.bootcamp;

public class Basic implements ConsultaSaldo,PagoServicios,RetiroEfectivo{


    public Basic() {
    }
    @Override
    public void consultaSaldo(){
        System.out.println("consultando Saldo");
    }
    @Override
    public void pagoServicio(){
        System.out.println("pagando servicios");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("retiro efectivo");
    }
}
