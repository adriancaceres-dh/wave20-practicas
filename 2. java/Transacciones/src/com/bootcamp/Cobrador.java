package com.bootcamp;

public class Cobrador {
    private ConsultaSaldo consultaSaldo;
    private RetiroEfectivo retiroEfectivo;
    public Cobrador(){
        consultaSaldo = new ConsultaSaldo();
        retiroEfectivo = new RetiroEfectivo();
    }
    public void consultaDeSaldo(){
        this.consultaSaldo.transaccionOk();
    }
    public void retiroDeEfecitvo(){
        this.retiroEfectivo.transaccionOk();
    }
}
