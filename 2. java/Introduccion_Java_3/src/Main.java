import com.bootcamp.Basic;
import com.bootcamp.Ejecutivos;

public class Main {
    public static void main(String[] args) {

        Ejecutivos ejecutivo = new Ejecutivos();
        ejecutivo.realizarDeposito(10000.0);
        ejecutivo.trasaccionOk("Deposito");

        Basic basic = new Basic();
        basic.RealizarConsultaDeSaldo();
        basic.realizarPagoDeServicios("Luz");
        basic.transaccionNoOk("Pago de Luz");
    }
}