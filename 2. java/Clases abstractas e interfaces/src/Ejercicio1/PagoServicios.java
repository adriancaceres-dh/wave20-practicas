package Ejercicio1;

public class PagoServicios implements Transacciones{
    // Si el servicio seleecionado es correcto se define como 1, 0 en caso contrario.
    public void realizarPagoServicio(int servicioAPagar) {
        if (servicioAPagar == 1) {
            transaccionOk(true);
        } else {
            transaccionNoOk(false);
        }
    }
    @Override
    public void transaccionOk(boolean exito) {
        System.out.println("Su servicio está siendo pagado.");
    }

    @Override
    public void transaccionNoOk(boolean exito) {
        System.out.println("El servicio seleccionado no es correcto.");
    }
}
