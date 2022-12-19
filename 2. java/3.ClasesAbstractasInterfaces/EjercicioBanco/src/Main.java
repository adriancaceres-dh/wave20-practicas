import com.bootcamp.Basic;
import com.bootcamp.Cobradores;
import com.bootcamp.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Basic basic = new Basic();
        Cobradores cobrador = new Cobradores();
        Ejecutivo ejecutivo = new Ejecutivo();

        basic.consultarSaldo();
        cobrador.retirarEfectivo();
        ejecutivo.realizarTransferencia();
        ejecutivo.transaccionOk("transferencia");
    }
}