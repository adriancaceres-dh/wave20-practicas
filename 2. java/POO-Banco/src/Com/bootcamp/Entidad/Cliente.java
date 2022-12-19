package Com.bootcamp.Entidad;

import Com.bootcamp.Interface.ICheckTransaccion;

public abstract class Cliente implements ICheckTransaccion {
    protected double saldo;

    public Cliente(){};
    public Cliente(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public void transaccionOk() {
        System.out.println("Transacion realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacion fallida");
    }

}
