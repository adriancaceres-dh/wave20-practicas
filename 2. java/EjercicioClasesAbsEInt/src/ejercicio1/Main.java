package ejercicio1;

import ejercicio1.clases.Basic;
import ejercicio1.clases.Cobrador;
import ejercicio1.clases.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejectivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();

        ejectivo.hacerDeposito();
        ejectivo.hacerTransferencia();
        cobrador.realizarRetiro();
        cobrador.consultarSaldo();
        basic.consultarSaldo();
        basic.pagarServicio();
        basic.realizarRetiro();
    }
}
