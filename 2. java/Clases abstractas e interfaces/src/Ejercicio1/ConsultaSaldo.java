package Ejercicio1;

public class ConsultaSaldo implements Transacciones {
    // El valor de 1 significa cuenta valida y 0 cuenta invalida
    public void realizarConsultaSaldo(int cuentaConsutalSaldo) {
        if (cuentaConsutalSaldo == 1) {
            transaccionOk(true);
        } else {
            transaccionNoOk(false);
        }
    }

    @Override
    public void transaccionOk(boolean exito) {
        System.out.println("Su operación está siendo procesada.");
    }

    @Override
    public void transaccionNoOk(boolean exito) {
        System.out.println("La cuenta seleccionada no existe.");
    }
}
