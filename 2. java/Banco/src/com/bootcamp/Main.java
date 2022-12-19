package com.bootcamp;

public class Main {
    public static void main(String[] args) {
    Basic pruebaBasic = new Basic();
    Cobrador pruebaCobrador = new Cobrador();
    Ejecutivo pruebaEjecutivo = new Ejecutivo();

        System.out.println("-------PRUEBA BASIC-------");
        pruebaBasic.realizarConsulta();
        pruebaBasic.realizarPago();
        pruebaBasic.hacerRetiro();
        System.out.println("-------FIN DE PRUEBA-------");

        System.out.println("-------PRUEBA COBRADOR-------");
        pruebaCobrador.hacerRetiro();
        pruebaCobrador.realizarConsulta();
        System.out.println("-------FIN DE PRUEBA-------");

        System.out.println("-------PRUEBA EJECUTIVO-------");
        pruebaEjecutivo.realizarDeposito();
        pruebaEjecutivo.realizarTransferencia();
        System.out.println("-------FIN DE PRUEBA-------");
    }
}