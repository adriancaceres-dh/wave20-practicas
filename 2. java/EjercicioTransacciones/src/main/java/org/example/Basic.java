package org.example;

public class Basic {
  public void realizarPagoServicios() {
    Transaccion transaccion = new PagoServicios();
    transaccion.transaccionOk();
    System.out.println("Realizando pago de servicios");
  }

  public void realizarRetiroEfectivo() {
    Transaccion transaccion = new RetiroEfectivo();
    transaccion.transaccionOk();
    System.out.println("Realizando retiro de efectivo");
  }

  public void realizarConsultaSaldo() {
    Transaccion transaccion = new ConsultaSaldo();
    transaccion.transaccionOk();
    System.out.println("Realizando consulta de saldo");
  }

}
