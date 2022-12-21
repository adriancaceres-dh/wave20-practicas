public class Basic extends Cliente implements IConsultaDeSaldo, IPagoDeServicios, IRetiroDeEfectivo{
    @Override
    public String consultarSaldo() {
        return "Realizando consulta de saldo...";
    }

    @Override
    public String pagarServicios() {
        return "Realizando pago de servicios...";
    }

    @Override
    public String retirarEfectivo() {
        return "Retirando efectivo...";
    }


}
