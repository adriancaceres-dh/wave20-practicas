package ej1;

public class Basic implements ISaldo, IServicio, IRetiro {

    @Override
    public void hacerRetiro() {
        System.out.println("hacer retiro");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("consultar saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("pagar servicio");
    }

    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
