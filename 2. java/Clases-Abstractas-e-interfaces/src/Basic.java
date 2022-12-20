public class Basic implements IBasic{

    public void ConsultaDeSaldo() {
        System.out.println("Consultando el saldo ...");
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.transaccionOk();
    }

    public void PagoDeServicios() {
        System.out.println("Pagando servicio ...");
        PagoDeServicios pagos = new PagoDeServicios();
        pagos.transaccionOk();
    }

    public void RetiroDeEfectivo()
    {
        System.out.println("Retirando efectivo ...");
        RetiroDeEfectivo retiros = new RetiroDeEfectivo();
        retiros.transaccionOk();
    }
}
