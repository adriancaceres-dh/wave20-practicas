package com.bootcamp;

public class Cliente {

    protected void realizarTransaccion(int t) {
        switch (t) {
            case 1:
                Deposito.transaccionOk();
                break;
            case 2:
                Transferencia.transaccionOk();
                break;
            case 3:
                Retiro.transaccionOk();
                break;
            case 4:
                ConsultaSaldo.transaccionOk();
                break;
            case 5:
                PagoServicio.transaccionOk();
                break;
        }
    }
}
