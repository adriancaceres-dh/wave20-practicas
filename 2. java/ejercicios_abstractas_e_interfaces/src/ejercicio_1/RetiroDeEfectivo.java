package ejercicio_1;

public class RetiroDeEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el retiro");
    }
}
