package banco.clases;

import banco.interfaces.ConsultaSaldo;
import banco.interfaces.RetiroEfectivo;

import java.util.Random;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    private Random rdm = new Random();
    @Override
    public void consultarSaldo() {
        if (rdm.nextBoolean()){
            transaccionOk("Consultar Saldo");
        } else {
            transaccionNoOk("Consultar Saldo");
        }
    }

    @Override
    public void retirarEfectivo(int monto) {
        if (rdm.nextBoolean()){
            transaccionOk("Retiro de Efectivo");
            System.out.println("Usted retiró $"+monto);
        } else {
            transaccionNoOk("Retiro de Efectivo");
            System.out.println("No tiene saldo suficiente para retiar. Intente con un monto menor a $" +monto);
        }
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("Transacción “"+tipoTransaccion+"“ realizada con éxito");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción “"+tipoTransaccion+"“ no fue exitosa");
    }
}
