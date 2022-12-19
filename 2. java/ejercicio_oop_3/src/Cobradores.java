public class Cobradores implements iTransaccion, iRetirodeEfectivo, iConsultaDeSaldo{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion No Ok");
    }

    @Override
    public void consultaDeSaldo() {
        System.out.println("Consultando Saldo...");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("Retirando Efectivo...");
    }
}
