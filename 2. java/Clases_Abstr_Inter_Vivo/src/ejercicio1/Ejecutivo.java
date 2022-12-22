package ejercicio1;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    public Ejecutivo(String nombre, String tipoCliente) {
        super(nombre, tipoCliente);
    }

    public void realizarDeposito() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo el deposito");
    }

    public void hacerTransferencia() {
        System.out.println("El cliente " + getNombre() + " de clase " + getTipoCliente() + " realizo la transferencia");
    }

    public void transaccionOk() {
    }

    public void transaccionNotOk() {
    }
}

