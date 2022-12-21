public class Cobrador extends Cliente implements ConsultaSaldo, RetiroEfectivo {

    public Cobrador(){

    }

    public void consultarSaldo(){
        Cliente consultaSaldo = new Cliente("consulta de saldo");
        consultaSaldo.ejecutarTransaccion();
        consultaSaldo.transaccionOk();// caso exitoso
        // transaccionNotOk(transaccion)
    }

    public void retirarEfectivo(){
        Cliente retirarEfectivo = new Cliente("retiro de efectivo");
        retirarEfectivo.ejecutarTransaccion();
        retirarEfectivo.transaccionOk(); // caso exitoso
        // transaccionNotOk(transaccion)
    }

    @Override
    @Deprecated
    public void transaccionOk(){
        throw new UnsupportedOperationException("Operacion no permitida, llamar desde una transaccion");
    }

    @Override
    @Deprecated
    public void transaccionNotOk(){
        throw new UnsupportedOperationException("Operacion no permitida, llamar desde una transaccion");
    }

    @Override
    @Deprecated
    public void ejecutarTransaccion(){
        throw new UnsupportedOperationException("Operacion no permitida, llamar desde una transaccion");
    }
}
