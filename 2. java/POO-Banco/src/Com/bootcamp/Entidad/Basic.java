package Com.bootcamp.Entidad;

import Com.bootcamp.Interface.IBasic;
import Com.bootcamp.Interface.ICheckTransaccion;
import Com.bootcamp.Interface.ITransaccionBasicYCobrador;

public class Basic extends Cliente implements ITransaccionBasicYCobrador, IBasic {

    public Basic() {
    }

    public Basic(double saldo) {
        super(saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println(saldo);
    }
    @Override
    public void retitoEfectivo(int e) {
        saldo-= e;
        super.transaccionNoOk();
    }
    @Override
    public void pagoServicios() {
        System.out.println("El servivio se esta pagado");
        super.transaccionOk();
    }
}
