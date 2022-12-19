package usuario;

import transaccion.Deposito;
import transaccion.Transaccion;
import transaccion.Transferencia;

public class Ejecutivo implements Cliente {
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof Deposito
                || transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
