package banco.interfaces;

public interface Transaccion {
    public abstract void transaccionOk(String tipoTransaccion);

    public abstract void transaccionNoOk(String tipoTransaccion);
}
