public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    public Ejecutivo(){

    }

    public void realizarTransferencia(){
        Cliente transferencia = new Cliente("transferencia");
        transferencia.ejecutarTransaccion();
        transferencia.transaccionOk();

    }

    public void depositar(){
        Cliente deposito = new Cliente("deposito");
        deposito.ejecutarTransaccion();
        deposito.transaccionOk();
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
