package transaccion;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta invalida");
    }
}
