package Ejercicio1;

public class Transferencia implements ITransacciones {
    @Override
    public void transaccionOk() {
        System.out.println("La transacción está siendo procesada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cuenta no encontrada. No es posible realizar operación.");
    }
}
