package banco.clases;

import banco.interfaces.Deposito;
import banco.interfaces.Transferencia;

import java.util.Random;

public class Ejecutivo implements Deposito, Transferencia {
    private Random rdm = new Random();

    @Override
    public void hacerDeposito() {
        if (rdm.nextBoolean()){
            transaccionOk("Depósito");
        } else {
            transaccionNoOk("Depósito");
        }
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Transacción “"+tipoTransaccion+"“ realizada con éxito");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción “"+tipoTransaccion+"“ no fue exitosa");
    }

    @Override
    public void hacerTransferencia(double monto) {
        if (rdm.nextBoolean()){
            transaccionOk("Transferencia");
            System.out.println("Se transfiró $"+monto);
        } else {
            transaccionNoOk("Transferencia");
        }
    }
}
