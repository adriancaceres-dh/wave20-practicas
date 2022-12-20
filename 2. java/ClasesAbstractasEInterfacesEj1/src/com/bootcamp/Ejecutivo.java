package com.bootcamp;

public class Ejecutivo extends Cliente implements iTransaccion{

    public Ejecutivo(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void realizarDeposito() {
        System.out.println("realizando desposito...");
        System.out.println(this.transaccionOk(true));
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
        System.out.println(this.transaccionOk(true));


    }

    @Override
    public void consultarSaldo() {
        System.out.println("Lo sentimos, usted no puede realizar esta operación");

    }

    @Override
    public void pagarServicios() {
        System.out.println("Lo sentimos, usted no puede realizar  esta operación");

    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Lo sentimos, usted no tien acceso a esta operación");


    }

    @Override
    public String transaccionOk(boolean estado) {

        if (estado) {
            return "Operacion realizada exitosamente";
        }else{
            return "Operación denegada";
        }

    }


}
