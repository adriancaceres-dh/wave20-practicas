package Ejercicio1;

public class Deposito implements ITransacciones {
    public Deposito() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Su operación está siendo procesada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Su número de cuenta selecionado no existe");
    }
}
