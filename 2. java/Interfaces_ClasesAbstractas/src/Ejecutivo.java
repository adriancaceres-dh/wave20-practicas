public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {

    @Override
    public String depositar() {
        return "realizando deposito...";
    }
    @Override
    public String transferir() {
        return "realizando transferencia...";
    }

}
