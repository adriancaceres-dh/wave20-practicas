package model;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Transferencia NOT OK");
    }
}
