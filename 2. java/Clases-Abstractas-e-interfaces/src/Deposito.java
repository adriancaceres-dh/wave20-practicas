public class Deposito extends Transacciones{
    public Deposito() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("----------> Transaccion de deposito OK.");
    }

    @Override
    public void transaccionNoOk()
    {
        System.out.println("-----------> Transaccion erronea - No Ok. ");
    }
}
