public class Cobradores implements ICobradores{

    public void RetiroDeEfectivo() {
        System.out.println("Retirando Efectivo... ");

        RetiroDeEfectivo retiro = new RetiroDeEfectivo();
        retiro.transaccionOk();
    }
    public void ConsultaDeSaldo() {
        System.out.println("Consultando Saldo... ");

        ConsultaDeSaldo consulta  = new ConsultaDeSaldo();
        consulta.transaccionOk();

    }
}
