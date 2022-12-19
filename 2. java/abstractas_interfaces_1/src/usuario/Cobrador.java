package usuario;

import transaccion.ConsultaSaldo;
import transaccion.RetiroEfectivo;
import transaccion.Transaccion;

public class Cobrador implements Cliente{
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof RetiroEfectivo
                || transaccion instanceof ConsultaSaldo){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
