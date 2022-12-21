package ej1;

public class Retiro implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro No OK");
    }
}
