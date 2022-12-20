package Ejercicio1.Clases;

import Ejercicio1.Intefaces.IConsultaSaldo;
import Ejercicio1.Intefaces.IRetiroEfectivo;

public class Cobradores extends Cliente implements IRetiroEfectivo, IConsultaSaldo {
    public Cobradores(String nombre) {
        super(nombre);
    }



    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void consultaSaldo(String cuenta, boolean estadoTransaccion) {
        System.out.println("Consultando saldo de la cuenta " + cuenta);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();
    }

    @Override
    public void retiroEfectivo(String cuenta, int cantidad, boolean estadoTransaccion) {
        System.out.println("Retirando efectivo de la cuenta " + cuenta + " la cantidad " + cantidad);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();

    }
}
