package com.bootcamp.banco.modelo;

public class Basic extends Persona implements ConsultaSaldo, PagoServicios, RetiroEfectivo,ITransaccion{

    public Basic(){

    }
    public Basic(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public void realizarConsulta(String password) {
        if (password.equals("123asd")){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }

    @Override
    public void PagarServicios(int monto, String servicio) {
        if (monto >0 && servicio != null){
            transaccionOk();
        }
        else {
            transaccionNoOk();
        }
    }

    @Override
    public void realizarRetiro(int monto) {
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
