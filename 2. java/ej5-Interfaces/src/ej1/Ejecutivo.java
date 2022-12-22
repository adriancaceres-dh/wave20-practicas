package ej1;

public class Ejecutivo implements IDeposito, ITransferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Hacer deposito");
    }

    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Hacer transferencia");
    }
}
