package model;

public class PagoDeServicio implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("pago de servicio OK");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("pago de servicio NOT OK");
    }
}
