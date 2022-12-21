import agencia.Cliente;
import agencia.Localizador;
import agencia.descuento.DescuentoFrecuente;
import agencia.descuento.DescuentoHotelViaje;
import agencia.descuento.DescuentoPaqueteCompleto;
import repositorio.RepositorioDescuentos;
import agencia.reserva.Reserva;
import agencia.reserva.TipoReserva;
import repositorio.RepositorioLocalizadores;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Setteo los descuentos
        RepositorioDescuentos.addDescuento(new DescuentoPaqueteCompleto(10));
        RepositorioDescuentos.addDescuento(new DescuentoFrecuente(5));
        RepositorioDescuentos.addDescuento(new DescuentoHotelViaje(5));

        TipoReserva reservaCompleta = new TipoReserva("Completa");
        TipoReserva reservaHotel = new TipoReserva("Hotel");
        TipoReserva reservaViaje = new TipoReserva("Viaje");


        Cliente cliente = new Cliente("Juan", "44444444");

        // Localizador con reserva completa
        Localizador localizador = new Localizador(cliente);
        cliente.addLocalizador(localizador);
        RepositorioLocalizadores.addLocalizador(localizador);
        localizador.addReserva(new Reserva(reservaCompleta, 500));
        System.out.println(localizador.costoTotal());
        System.out.println("-------------------------");

        // Localizador con dos reservas de hotel y dos viajes
        Localizador localizadorReservas = new Localizador(cliente);
        cliente.addLocalizador(localizadorReservas);
        RepositorioLocalizadores.addLocalizador(localizadorReservas);
        for(int i = 0; i < 2; i++) {
            localizadorReservas.addReserva(new Reserva(reservaHotel, 100));
            localizadorReservas.addReserva(new Reserva(reservaViaje, 250));
        }
        System.out.println(localizadorReservas.costoTotal());
        System.out.println("-------------------------");

        Localizador localizadorClienteFrecuente = new Localizador(cliente);
        cliente.addLocalizador(localizadorClienteFrecuente);
        RepositorioLocalizadores.addLocalizador(localizadorClienteFrecuente);
        localizadorClienteFrecuente.addReserva(new Reserva(reservaHotel, 50));
        System.out.println(localizadorClienteFrecuente.costoTotal());
        System.out.println("-------------------------");

        System.out.println("Localizadores vendidos: " + RepositorioLocalizadores.listLocalizadores().size());
        int cantidadReservas = RepositorioLocalizadores.listLocalizadores().stream()
                .mapToInt(l -> l.getReservas().size())
                .sum();
        System.out.println("Reservas vendidas: " + cantidadReservas);
        System.out.println("-------------------------");
        ArrayList<Reserva> reservas = new ArrayList<>();
        RepositorioLocalizadores.listLocalizadores().forEach(l -> reservas.addAll(l.getReservas()));
        HashMap<String, ArrayList<Reserva>> reservasPorTipo = new HashMap<>();
        reservas.forEach(r -> {
            var listaReservasDeTipo = reservasPorTipo.get(r.getTipoReserva().getNombre());
            if (listaReservasDeTipo == null) {
                ArrayList<Reserva> reservasDeTipo = new ArrayList<>();
                reservasDeTipo.add(r);
                reservasPorTipo.put(r.getTipoReserva().getNombre(), reservasDeTipo);
            } else {
                listaReservasDeTipo.add(r);
            }
        });
        System.out.println("Reservas por tipo: " + reservasPorTipo);
        System.out.println("-------------------------");
        double totalDeVentas = RepositorioLocalizadores.listLocalizadores().stream()
                .mapToDouble(Localizador::costoTotal)
                .sum();
        double promedio = RepositorioLocalizadores.listLocalizadores().stream()
                .mapToDouble(Localizador::costoTotal)
                .average()
                .getAsDouble();
        System.out.println("Total de ventas: " + totalDeVentas);
        System.out.println("Promedio de ventas: " + promedio);
        System.out.println("-------------------------");
    }
}