package Ejercicio1;

public class PagoServicios implements ITransacciones {

    @Override
    public void transaccionOk() {
        System.out.println("Su operación está siendo procesada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Su operación no es posible. Verifique el servicio a pagar nuevamente.");
    }
}
