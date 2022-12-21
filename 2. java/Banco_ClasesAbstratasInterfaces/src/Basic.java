public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    @Override
    public void pagarServicios() {
        Cliente pagoServicios = new Cliente("pago de servicios");
        pagoServicios.ejecutarTransaccion();
        pagoServicios.transaccionOk();
    }

    @Override
    public void consultarSaldo(){
        Cliente consultaSaldo = new Cliente("consulta de saldo");
        consultaSaldo.ejecutarTransaccion();
        consultaSaldo.transaccionOk();// caso exitoso
        // transaccionNotOk(transaccion)
    }

    @Override
    public void retirarEfectivo(){
        Cliente retirarEfectivo = new Cliente("retiro de efectivo");
        retirarEfectivo.ejecutarTransaccion();
        retirarEfectivo.transaccionOk(); // caso exitoso
        // transaccionNotOk(transaccion)
    }

    // Override de metodos heredados para que levanten excepciones al ser llamados desde esta clase
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
