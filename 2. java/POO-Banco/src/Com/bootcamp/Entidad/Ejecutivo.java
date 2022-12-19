package Com.bootcamp.Entidad;

import Com.bootcamp.Interface.ICheckTransaccion;
import Com.bootcamp.Interface.ITransaccionEjecutivo;

public class Ejecutivo extends Cliente  implements ITransaccionEjecutivo {
    public Ejecutivo() {
    }
    public Ejecutivo(double saldo) {
        super(saldo);
    }
    @Override
    public void depositar(double d) {
        saldo+= d;
        super.transaccionOk();
    }

    @Override
    public void Tranferir(double tranf) {
        if(tranf<=saldo){
            saldo-= tranf;
            super.transaccionOk();
        }else{
            super.transaccionNoOk();
        }
    }
}
