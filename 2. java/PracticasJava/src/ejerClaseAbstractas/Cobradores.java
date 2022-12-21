package ejerClaseAbstractas;

public class Cobradores extends Cliente implements ITransaccion {
    public Cobradores(String nombre) {
        super(nombre);
    }

    @Override
    public void consultaDeSaldo() {
        super.consultaDeSaldo();
        System.out.println("ok retiro --" + transaccionok());
    }

    @Override
    public void retiroDeEfectivo() {
        super.retiroDeEfectivo();
        System.out.println("No retiro --" + trasaccionNoOK());
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
