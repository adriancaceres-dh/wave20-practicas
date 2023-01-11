package ejercicio_1;

public class PagoDeServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios correcto");
    }

    @Override
    public void transaccionNoOk() {

        System.out.println("Error en el pago de servicio");

    }
}
