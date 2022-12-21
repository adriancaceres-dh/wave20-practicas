package ej1;

public class Ejecutivo extends Cliente{
    public void realizarDeposito(Deposito d) {
        System.out.println("Realizándose depósito");
    }
    public void realizarTransferencia(Transferencia t) {
        System.out.println("Realizándose transferencia");
    }
}
