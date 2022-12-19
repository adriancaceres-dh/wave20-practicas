package usuario;

import transaccion.ConsultaSaldo;
import transaccion.PagoServicios;
import transaccion.RetiroEfectivo;
import transaccion.Transaccion;

public class Basic implements Cliente {

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof ConsultaSaldo
                || transaccion instanceof RetiroEfectivo
                || transaccion instanceof PagoServicios){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
