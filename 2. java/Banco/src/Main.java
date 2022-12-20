import com.bootcamp.clientes.Basico;
import com.bootcamp.clientes.Cobrador;
import com.bootcamp.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basico clienteBasico = new Basico();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        clienteBasico.consultarSaldo(20);
        clienteBasico.consultarSaldo(-5);
        clienteBasico.pagarServicio("Luz");
        clienteBasico.pagarServicio("Gas");
        clienteBasico.retirarEfectivo(3000);
        clienteBasico.retirarEfectivo(-50);

        cobrador.consultarSaldo(3);
        cobrador.consultarSaldo(-5);
        cobrador.retirarEfectivo(5400);
        cobrador.retirarEfectivo(-5400);

        ejecutivo.realizarDeposito(50000);
        ejecutivo.realizarDeposito(-3);
        ejecutivo.realizarTransferencia(30000);
        ejecutivo.realizarTransferencia(-1);
    }
}