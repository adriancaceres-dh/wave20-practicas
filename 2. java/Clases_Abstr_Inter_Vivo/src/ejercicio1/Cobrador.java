package ejercicio1;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo {
    public Cobrador(String nombre, String tipoCliente) {
        super(nombre, tipoCliente);
    }

    public void consultarSaldo() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo la consulta de saldo");
    }

    public void retirarEfectivo() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo el retiro en efectivo");
    }

    public void transaccionOk() {
    }

    public void transaccionNotOk() {
    }
}
