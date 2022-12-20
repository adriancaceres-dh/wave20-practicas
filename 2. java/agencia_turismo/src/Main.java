import agencia.Cliente;
import agencia.Localizador;
import agencia.descuento.DescuentoFrecuente;
import agencia.descuento.DescuentoPaqueteCompleto;
import agencia.repositorio.RepositorioDescuentos;
import agencia.reserva.Reserva;
import agencia.reserva.TipoReserva;

public class Main {
    public static void main(String[] args) {
        // Setteo los descuentos
        RepositorioDescuentos.addDescuento(new DescuentoPaqueteCompleto(10));
        RepositorioDescuentos.addDescuento(new DescuentoFrecuente(5));

        Cliente cliente = new Cliente("Juan", "44444444");
        Localizador localizador = new Localizador(cliente);
        cliente.addLocalizador(localizador);
        TipoReserva reservaCompleta = new TipoReserva("Completa");
        localizador.addReserva(new Reserva(reservaCompleta, 500));
        System.out.println(localizador.costoTotal());
    }
}