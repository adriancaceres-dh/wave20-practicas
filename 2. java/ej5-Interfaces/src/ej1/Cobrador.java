package ej1;

public class Cobrador implements IRetiro, ISaldo {

    @Override
    public void hacerRetiro() {
        System.out.println("hacer retiro");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("consultar saldo");
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
