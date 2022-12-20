public class Ejecutivos implements IEjecutivos{
    public Ejecutivos()
    {
    }

    public void HacerDeposito()
    {
        System.out.println("Realizando deposito.. ");
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void HacerTransferencia()
    {
        System.out.println("Realizando transferencia.. ");
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}
