package model;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("transaccion OK");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("transaccion not ok");
    }
}
