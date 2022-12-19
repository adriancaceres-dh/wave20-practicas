package Com.bootcamp.Entidad;

import Com.bootcamp.Interface.ITransaccionBasicYCobrador;

import java.math.BigDecimal;

public class Cobradores extends  Cliente implements ITransaccionBasicYCobrador {

    public Cobradores() {
    }

    public Cobradores(double saldo) {
        super(saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println(this.saldo);
        super.transaccionOk();
    }
    @Override
    public void retitoEfectivo(int efectivo) {
       if(efectivo <= saldo){
           saldo -= efectivo;
           super.transaccionOk();
       }else{
           super.transaccionNoOk();
       }
    }
}
