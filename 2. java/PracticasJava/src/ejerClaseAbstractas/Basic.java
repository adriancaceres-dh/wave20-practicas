package ejerClaseAbstractas;

public class Basic extends Cliente implements ITransaccion {
    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void consultaDeSaldo() {
        super.consultaDeSaldo();
        System.out.println(" ok consulta de saldo --" + transaccionok());
    }

    @Override
    public void pagosDeServicio() {
        super.pagosDeServicio();
        System.out.println("ok opago de servicio --" + transaccionok());
    }

    @Override
    public void retiroDeEfectivo() {
        super.retiroDeEfectivo();
        System.out.println("ok retiro --" + transaccionok());
    }

    @Override
    public boolean transaccionok() {
        return true;
    }

    @Override
    public boolean trasaccionNoOK() {
        return false;
    }
}
