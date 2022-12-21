package ej1;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Depósito No OK");
    }
}
