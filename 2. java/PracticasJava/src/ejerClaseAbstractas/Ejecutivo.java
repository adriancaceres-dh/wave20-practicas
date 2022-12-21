package ejerClaseAbstractas;

public class Ejecutivo extends Cliente implements ITransaccion {
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarDeposito() {
        super.realizarDeposito();
        System.out.println("ok deposito --" + transaccionok());
    }

    @Override
    public void tranferencias() {
        super.tranferencias();
        System.out.println("ok tranferencia --" + trasaccionNoOK());
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
