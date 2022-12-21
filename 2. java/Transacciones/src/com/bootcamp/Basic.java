package com.bootcamp;

public class Basic {

    private ConsultaSaldo consultaSaldo;
    private PagoDeServicios pagoDeServicios;
    private RetiroEfectivo retiroEfectivo;
    public Basic(){
        consultaSaldo = new ConsultaSaldo();
        pagoDeServicios = new PagoDeServicios();
        retiroEfectivo = new RetiroEfectivo();
    }
    public void consultaDeSaldo(){
        this.consultaSaldo.transaccionOk();
    }

    public void pagoServicios(){
        pagoDeServicios.transaccionOk();
    }

    public void retiroDeEfecitvo(){
        this.retiroEfectivo.transaccionOk();
    }
}
