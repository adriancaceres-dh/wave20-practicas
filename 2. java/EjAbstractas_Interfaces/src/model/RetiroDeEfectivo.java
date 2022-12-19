package model;

public class RetiroDeEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo OK");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Retiro de efectivo NOT OK");
    }
}
