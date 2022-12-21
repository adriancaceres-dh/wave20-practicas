package Ejercicio1;

public class RetiroDeEfectivo implements ITransacciones {

    @Override
    public void transaccionOk() {
        System.out.println("Se esta realizando su operación.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No posee suficiente dinero.");
    }
}
