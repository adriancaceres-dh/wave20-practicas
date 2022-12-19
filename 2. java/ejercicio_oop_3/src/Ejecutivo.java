public class Ejecutivo implements iTransaccion, iDeposito, iTransferencia{
    @Override
    public void hacerDeposito() {
        System.out.println("Haciendo Deposito...");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Hacinedo Transaccion...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion No Ok");
    }
}
