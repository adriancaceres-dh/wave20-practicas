package ejercicio_1;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el deposito");
    }
}
