package com.bootcamp;

public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public void RealizarConsultaDeSaldo() {
        System.out.println("Consulta de saldo");
    }

    @Override
    public void realizarRetiroDeEfectivo(double monto) {
        System.out.println("Se realizó el retiro de $" + monto);
    }

    @Override
    public void trasaccionOk(String transaccion) {
        System.out.println(transaccion + " exitoso");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println(transaccion + " falló");
    }
}
