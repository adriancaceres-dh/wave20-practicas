package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Ejecutivo Diego = new Ejecutivo("Diego Malagon","1019");
        Basic Alejandro = new Basic("Alejandro Ruiz","2022");
        Cobradores Maria = new Cobradores("Maria Cruz", "3977");

        Maria.realizarDeposito();
        Diego.realizarTransferencia();
        Alejandro.realizarTransferencia();

    }
}