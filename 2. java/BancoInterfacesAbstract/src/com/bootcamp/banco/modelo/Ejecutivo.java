package com.bootcamp.banco.modelo;

public class Ejecutivo extends Persona implements Deposito,Transferencia, ITransaccion {
    public Ejecutivo(){

    }
    public Ejecutivo(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public void realizarDesposito(int monto) {
        if (monto >0 ){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }

    @Override
    public void realizarTransferencia(int monto, String cuentaDestino) {
        if (monto >0 ){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }
    @Override
    public void transaccionOk() {
        String respuesta = "La operación se realizó correctamente por el usuario "+getNombre();
        System.out.println(respuesta);
    }

    @Override
    public void transaccionNoOk() {
        String respuesta = "Error al realizar la operacion";
        System.out.println(respuesta);
    }



}
