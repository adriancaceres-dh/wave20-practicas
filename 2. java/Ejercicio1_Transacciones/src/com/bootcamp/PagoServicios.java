package com.bootcamp;

public class PagoServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Servicio pagado exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido realizar el pago, verifique los datos");
    }
}
