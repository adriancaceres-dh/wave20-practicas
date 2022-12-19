package org.example;

public class Ejecutivo {
  public void realizarDeposito() {
    Transaccion transaccion = new Deposito();
    transaccion.transaccionOk();
    System.out.println("Realizando deposito");
  }

  public void realizarTransferencia() {
    Transaccion transaccion = new Transferencia();
    transaccion.transaccionOk();
    System.out.println("Realizando transferencia");
  }
}
