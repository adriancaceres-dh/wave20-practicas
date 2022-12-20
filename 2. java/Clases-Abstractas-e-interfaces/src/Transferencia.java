public class Transferencia extends Transacciones
{
    public Transferencia() {
    }

    public void transaccionOk()
    {
        System.out.println("------> Transaccion de transferencia OK.");
    }

    public void transaccionNoOk()
    {
        System.out.println("------> Transferencia no Ok.");
    }
}
