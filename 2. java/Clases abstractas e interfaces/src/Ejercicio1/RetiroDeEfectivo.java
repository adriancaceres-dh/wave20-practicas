package Ejercicio1;

public class RetiroDeEfectivo implements ITransacciones {

    // Solo se aceptara 1 posee dinero suficiente, 0 en caso contrario.
    public void realizarRetiroDeDinero(int dinero) {
        if (dinero == 1) {
            transaccionOk(true);
        } else {
            transaccionNoOk(false);
        }
    }
    @Override
    public void transaccionOk(boolean exito) {
        System.out.println("Se esta realizando su operación.");
    }

    @Override
    public void transaccionNoOk(boolean exito) {
        System.out.println("No posee suficiente dinero.");
    }
}
