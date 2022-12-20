package ejercicio1.clases;

import ejercicio1.interfaces.Retiro;
import ejercicio1.interfaces.Saldo;

public class Cobrador implements Retiro, Saldo {

    public void realizarRetiro() {
        System.out.println("Realizandor retiro...");
        transaccionOk();
    }

    public void transaccionOk(){
        System.out.println("Transaccion realizada correctamente");
    }

    public void transaccionNoOk(){
        System.out.println("La transaccion no ha podido ser realizada");
    }


    public void consultarSaldo() {
        System.out.println("Realizando consilta de saldo...");
        transaccionOk();
    }
}
