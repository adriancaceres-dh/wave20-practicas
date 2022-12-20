package Ejercicio1;

public class Deposito implements ITransacciones {
    public Deposito() {
    }

    // Solo se aceptara 1 simplicando que la cuenta a depositar existe, 0 en caso contrario.
    public void realizarDeposito(int cuentaADepositar) {

    }

    @Override
    public void transaccionOk() {
        System.out.println("Su operación está siendo procesada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Su numero de cuenta selecionado no existe");
    }
}
