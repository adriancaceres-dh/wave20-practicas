package com.bootcamp;

public class Cobradores extends Cliente implements iTransaccion{

    public Cobradores(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Lo sentimos, usted no tiene acceso a esta operación");


    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Lo sentimos, usted no tiene acceso a esta operación");


    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        System.out.println(this.transaccionOk(true));
    }

    @Override
    public void pagarServicios() {
        System.out.println("Lo sentimos, usted no tiene acceso a esta operación");


    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
        System.out.println(this.transaccionOk(true));
    }

    @Override
    public String transaccionOk(boolean estado) {
        if (estado) return "Operacion realizada exitosamente";
        else return "Operacion denegada!!!";
    }
}
