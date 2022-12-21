package ej1;

public class Pago implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago No OK");
    }
}
