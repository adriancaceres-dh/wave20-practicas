package com.bootcamp;

public interface iTransaccion {

    public void realizarDeposito();
    public void realizarTransferencia();
    public void consultarSaldo();
    public void pagarServicios();
    public void retirarEfectivo();
    public String transaccionOk(boolean estado);

}
