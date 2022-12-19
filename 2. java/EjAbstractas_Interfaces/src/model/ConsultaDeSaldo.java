package model;

public class ConsultaDeSaldo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de salgo OK");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Consulta de salgo NOT OK");
    }
}
