package com.bootcamp;

public class Basic extends Cliente implements iTransaccion{

    public Basic(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Lo sentimos, usted no puede realizar esta operación");

    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Lo sentimos, usted no puede realizar esta operación");

    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        System.out.println(this.transaccionOk(true));
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios...");
        System.out.println(this.transaccionOk(true));
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
