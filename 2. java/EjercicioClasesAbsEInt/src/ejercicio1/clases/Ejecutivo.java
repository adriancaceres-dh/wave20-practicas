package ejercicio1.clases;

import ejercicio1.interfaces.Deposito;
import ejercicio1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    public void hacerDeposito(){
        System.out.println("Realizando deposito....");
        transaccionOk();
    }

    public void transaccionOk(){
        System.out.println("Transaccion realizada correctamente");
    }

    public void transaccionNoOk(){
        System.out.println("La transaccion no ha podido ser realizada");
    }

    public void hacerTransferencia() {
        System.out.println("Realizando transferencia....");
        transaccionOk();
    }
}
