public abstract class Cliente implements ITransaccion{
    public String transaccionOk(){
        return "Transaccion realizada con exito.";
    }

    public String transaccionNoOk() {
        return "No se pudo realizar la transaccion";
    }
}
