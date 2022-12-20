package Ejercicio1.Clases;

import Ejercicio1.Intefaces.IConsultaSaldo;
import Ejercicio1.Intefaces.IPagoServicios;
import Ejercicio1.Intefaces.IRetiroEfectivo;

public class Basic extends Cliente implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {
    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void consultaSaldo(String cuenta, boolean estadoTransaccion) {
        System.out.println("Consultando el saldo de la cuenta " + cuenta);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();
    }

    @Override
    public void pagarServicios(String nombreServicio, boolean estadoTransaccion) {
        System.out.println("Pagando el servicio " + nombreServicio);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();
    }

    @Override
    public void retiroEfectivo(String cuenta, int cantidad, boolean estadoTransaccion) {
        System.out.println("Retirando efectivo de la cuenta: " + cuenta + " la cantidad de " + cantidad);
        if(estadoTransaccion)
            transaccionOk();
        else
            transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no fue realizada correctamente");
    }
}
