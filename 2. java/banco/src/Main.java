import com.bootcamp.clientes.Ejecutivo;
import com.bootcamp.transacciones.Deposito;

public class Main {
    public static void main(String[] args) {
        Ejecutivo e1 = new Ejecutivo();
        e1.getServicioDeposito().realizarDeposito(false);
    }
}