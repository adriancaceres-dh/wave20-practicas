public class Basic implements iTransaccion, iConsultaDeSaldo, iPagodeServicio, iRetirodeEfectivo{
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
    public void pagodeServicio() {
        System.out.println("Pagando Servicios...");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("Retirando Efectivo...");
    }
}
