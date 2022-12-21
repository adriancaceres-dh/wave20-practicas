package ej1;

public class Consulta implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta No OK");
    }
}
