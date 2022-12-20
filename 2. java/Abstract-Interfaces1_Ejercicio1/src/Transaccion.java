public interface Transaccion {

    public abstract boolean transaccionOK(String tipo);
    public abstract boolean transaccionNoOK(String tipo);

}
