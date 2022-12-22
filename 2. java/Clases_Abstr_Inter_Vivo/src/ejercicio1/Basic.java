package ejercicio1;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    public Basic(String nombre, String tipoCliente) {
        super(nombre, tipoCliente);
    }

    public void consultarSaldo() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo la consulta de saldo");
    }

    public void pagarServicios() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo el pago de servicios");
    }

    public void retirarEfectivo() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo el retiro en efectivo");
    }

    public void transaccionOk() {
    }

    public void transaccionNotOk() {
    }
}