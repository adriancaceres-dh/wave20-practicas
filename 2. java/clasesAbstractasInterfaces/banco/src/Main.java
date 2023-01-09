import com.bootcamp.clientes.Basic;
import com.bootcamp.clientes.Cobrador;
import com.bootcamp.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo(1, "Pepe");
        ejecutivo.realizarDeposito();
        ejecutivo.transaccionOk();

        Basic basic = new Basic(2, "Juan");
        basic.realizarConsultaSaldo();
        basic.transaccionNoOk();

        Cobrador cobrador = new Cobrador(3, "Maria");
        cobrador.realizarRetiroEfectivo();


    }
}