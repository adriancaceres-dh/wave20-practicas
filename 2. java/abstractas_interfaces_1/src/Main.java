import transaccion.*;
import usuario.Basic;
import usuario.Cliente;
import usuario.Cobrador;
import usuario.Ejecutivo;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo();
        Cliente cobrador = new Cobrador();
        Cliente basic = new Basic();
        List<Transaccion> posiblesTransacciones = List.of(
                new ConsultaSaldo(),
                new Deposito(),
                new PagoServicios(),
                new RetiroEfectivo(),
                new Transferencia());
        posiblesTransacciones.forEach( transaccion -> {
            System.out.println("-------------------------");
            System.out.println("Ejecutivo: ");
            ejecutivo.realizarTransaccion(transaccion);
            System.out.println("Cobrador: ");
            cobrador.realizarTransaccion(transaccion);
            System.out.println("Basic: ");
            basic.realizarTransaccion(transaccion);
            System.out.println("-------------------------");
        });
    }
}