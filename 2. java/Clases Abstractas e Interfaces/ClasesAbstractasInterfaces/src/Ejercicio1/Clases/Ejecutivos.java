package Ejercicio1.Clases;

import Ejercicio1.Intefaces.IDeposito;
import Ejercicio1.Intefaces.ITransferencia;

public class Ejecutivos extends Cliente implements IDeposito, ITransferencia {
    public Ejecutivos(String nombre) {
        super(nombre);
    }


    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void depositar(String cuenta, int monto, boolean estadoTransaccion) {
        System.out.println("Depositando en la cuenta " + cuenta + " el monto de " + monto);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();
    }

    @Override
    public void transferencia(String cuenta, int monto, boolean estadoTransaccion) {
        System.out.println("Haciendo la transferencia a la cuenta " + cuenta + " del monto " + monto);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();
    }
}
