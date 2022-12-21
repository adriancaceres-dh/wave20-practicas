public class Cobrador extends Cliente implements IRetiroDeEfectivo, IConsultaDeSaldo {
    @Override
    public String consultarSaldo() {
        return "Consultando saldo...";
    }

    @Override
    public String retirarEfectivo() {
        return "Realizando retiro de efectivo...";
    }
}
