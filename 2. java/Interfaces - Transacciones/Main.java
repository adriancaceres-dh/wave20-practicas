package com.bootcamp;

public class Main {

    public static void main(String[] args) {

        System.out.println("-----BANCO INTERFACES DEL PAÍS-----");
        Ejecutivo ejec = new Ejecutivo();
        ejec.hacerDeposito();
        ejec.hacerTransferencia();
        ejec.transaccionNoOk("Depósito");
        ejec.transaccionOk("Transferencia");


    }
}
