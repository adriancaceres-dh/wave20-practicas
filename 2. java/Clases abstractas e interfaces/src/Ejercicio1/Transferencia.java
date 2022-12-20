package Ejercicio1;

public class Transferencia implements ITransacciones {
    // Solo se aceptara 1 simplicando que la cuenta a depositar existe, 0 en caso contrario.
    public void realizarTransferencia(int cuentaTransferencia) {
        if (cuentaTransferencia == 1) {
            transaccionOk(true);
        } else {
            transaccionNoOk(false);
        }
    }
    @Override
    public void transaccionOk(boolean exito) {
        System.out.println("La transacción está siendo procesada.");
    }

    @Override
    public void transaccionNoOk(boolean exito) {
        System.out.println("Cuenta no encontrada. No es posible realizar operación.");
    }
}
