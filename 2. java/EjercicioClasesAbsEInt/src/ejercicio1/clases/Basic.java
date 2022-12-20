package ejercicio1.clases;

import ejercicio1.interfaces.PagoDeServicios;
import ejercicio1.interfaces.Retiro;
import ejercicio1.interfaces.Saldo;

public class Basic implements Saldo, PagoDeServicios, Retiro {

    public void pagarServicio() {
        System.out.println("Pagando servicio...");
        transaccionOk();
    }


    public void realizarRetiro() {
        System.out.println("Realizando retiro...");
        transaccionOk();
    }


    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    public void transaccionOk(){
        System.out.println("Transaccion realizada correctamente");
    }

    public void transaccionNoOk(){
        System.out.println("La transaccion no ha podido ser realizada");
    }
}
