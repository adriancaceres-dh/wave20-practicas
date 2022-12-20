package Ejercicio1;

public class Ejecutivos extends Usuarios {

    public Ejecutivos(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public void realizarDeposito(int cantEfectivoDepositar) {
        Deposito nuevaT = new Deposito();
        // Aquí debería verificar que la cuenta exista para colocar el 1 o 0. Además si tiene la cantidad de $ suficiente.
        if (cantEfectivoDepositar == 1) {
            nuevaT.transaccionOk();
        } else {
            nuevaT.transaccionNoOk();
        }
    }

    public void realizarTransferencia(int cantDinero) {
        Transferencia nuevaT = new Transferencia();
        // Aquí debería verificar que la cuenta exista para colocar el 1 o 0. Además si tiene la cantidad de $ suficiente.
        nuevaT.realizarTransferencia(cantDinero);
    }
}
