package org.example;

public class Main {
  public static void main(String[] args) {
    Basic basic = new Basic();
    Cobrador cobrador = new Cobrador();
    Ejecutivo ejecutivo = new Ejecutivo();
    basic.realizarConsultaSaldo();
    basic.realizarRetiroEfectivo();
    basic.realizarPagoServicios();
    cobrador.realizarConsultaSaldo();
    cobrador.realizarRetiroEfectivo();
    ejecutivo.realizarDeposito();
    ejecutivo.realizarTransferencia();
  }
}