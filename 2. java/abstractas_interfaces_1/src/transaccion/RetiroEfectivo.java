package transaccion;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro reaizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro invalido");
    }
}
