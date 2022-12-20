package com.bootcamp.operaciones;

public class PagoServicio  implements TransaccionInterface{

    public void pagar(String nombreServicio) {
        // El gas debe ser pagado personalmente
        if(nombreServicio.equals("Gas")) {
            transaccionNoOk();
        } else {
            transaccionOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("El pago del servicio ha sido exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el pago del servicio");
    }
}
