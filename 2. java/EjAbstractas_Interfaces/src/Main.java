import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Deposito deposito = new Deposito();
        deposito.transaccionNotOk();
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.getListaTransaccion().add(deposito);

        ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
        consultaDeSaldo.transaccionOk();
        Cliente cliente = new Basic();
        cliente.getListaTransaccion().add(consultaDeSaldo);
    }
}