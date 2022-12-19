package Ejercicio1;

public class Deposito implements Transacciones {
    public Deposito() {
    }

    // Solo se aceptara 1 simplicando que la cuenta a depositar existe, 0 en caso contrario.
    public void realizarDeposito(int cuentaADepositar) {
        if (cuentaADepositar == 1) {
            transaccionOk(true);
        } else {
            transaccionNoOk(false);
        }
    }

    @Override
    public void transaccionOk(boolean exito) {
        System.out.println("Su operación está siendo procesada");
    }

    @Override
    public void transaccionNoOk(boolean exito) {
        System.out.println("Su numero de cuenta selecionado no existe");
    }
}
