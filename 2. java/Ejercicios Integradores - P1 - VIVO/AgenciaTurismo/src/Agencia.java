import com.bootcamp.clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agencia {

    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
        Cliente cliente1 = new Cliente("123", "Pedro", "Domínguez");
        if (!repositorioCliente.existeCliente(cliente1)) {
            repositorioCliente.adicionarCliente(cliente1);
        }

        //Creando paquete completo para el cliente
        List<Reserva> reservas = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        Hotel hotel1 = new Hotel(5000, fechaActual, "Pocitos Plaza Hotel", 4);
        Comida comida1 = new Comida(500, fechaActual, "Japonesa");
        Transporte transporte1 = new Transporte(800, fechaActual, "Taxi");
        BoletoViaje boletoViaje1 = new BoletoViaje(2500, fechaActual, "1ra Clase");
        reservas.add(hotel1);
        reservas.add(comida1);
        reservas.add(transporte1);
        reservas.add(boletoViaje1);
        Localizador localizador = new Localizador(cliente1, reservas);
        localizador.calcularTotalReserva(repositorioLocalizador.getLocalizadores());
        repositorioLocalizador.adicionarLocalizador(localizador);

        //Reservando 2 hoteles y 2 boletos de viaje para el mismo cliente
        List<Reserva> reservas2 = new ArrayList<>();
        Hotel hotel2 = new Hotel(4000, fechaActual, "Hotel Cottage", 4);
        Hotel hotel3 = new Hotel(2000, fechaActual, "Hotel America", 3);
        BoletoViaje boletoViaje2 = new BoletoViaje(2000, fechaActual, "1ra Clase");
        BoletoViaje boletoViaje3 = new BoletoViaje(1800, LocalDate.of(2022, 05, 24), "2da Clase");
        reservas2.add(hotel2);
        reservas2.add(hotel3);
        reservas2.add(boletoViaje2);
        reservas2.add(boletoViaje3);
        Localizador localizador2 = new Localizador(cliente1, reservas2);
        localizador2.calcularTotalReserva(repositorioLocalizador.getLocalizadores());
        repositorioLocalizador.adicionarLocalizador(localizador2);

        //Reservando una sola reserva para el mismo cliente
        List<Reserva> reservas3 = new ArrayList<>();
        Hotel hotel4 = new Hotel(8000, LocalDate.of(2022, 07, 15), "Radisson Montevideo Victoria Plaza", 5);
        reservas3.add(hotel4);
        Localizador localizador3 = new Localizador(cliente1, reservas3);
        localizador3.calcularTotalReserva(repositorioLocalizador.getLocalizadores());
        repositorioLocalizador.adicionarLocalizador(localizador3);

        //Cantidad de localizadores vendidos.
        System.out.println("Cantidad de localizadores vendidos: " + repositorioLocalizador.getLocalizadores().size());

        int totalReservas = repositorioLocalizador.getLocalizadores().stream().mapToInt(x -> x.getReservas().size()).sum();
        //Cantidad total de reservas
        System.out.println("Cantidad total de reservas: " + totalReservas);

        //Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
        List<Reserva> listaReservas = new ArrayList<>();
        Map<String, List<Reserva>> reservasClasificadas = new HashMap<>();
        reservasClasificadas.put("hotel", new ArrayList<>());
        reservasClasificadas.put("comida", new ArrayList<>());
        reservasClasificadas.put("boleto", new ArrayList<>());
        reservasClasificadas.put("transporte", new ArrayList<>());
        for (Localizador x1 : repositorioLocalizador.getLocalizadores()) {
            List<Reserva> xReservas = x1.getReservas();
            List<Reserva> reservasHotel = xReservas.stream().filter(x -> x instanceof Hotel).collect(Collectors.toList());
            List<Reserva> reservasBoleto = xReservas.stream().filter(x -> x instanceof BoletoViaje).collect(Collectors.toList());
            List<Reserva> reservasComida = xReservas.stream().filter(x -> x instanceof Comida).collect(Collectors.toList());
            List<Reserva> reservasTransporte = xReservas.stream().filter(x -> x instanceof Transporte).collect(Collectors.toList());
            if (reservasHotel.size() > 0) {
                reservasClasificadas.get("hotel").addAll(reservasHotel);
            }
            if (reservasBoleto.size() > 0) {
                reservasClasificadas.get("boleto").addAll(reservasBoleto);
            }
            if (reservasComida.size() > 0) {
                reservasClasificadas.get("comida").addAll(reservasComida);
            }
            if (reservasTransporte.size() > 0) {
                reservasClasificadas.get("transporte").addAll(reservasTransporte);
            }
        }
        System.out.println("Reservas clasificadas por tipo: ");
        for (Map.Entry<String, List<Reserva>> r : reservasClasificadas.entrySet()) {
            System.out.println(r.getKey() + " -> " + r.getValue());
        }

        //Total de ventas.
        double totalVentas = repositorioLocalizador.getLocalizadores().stream().mapToDouble(x -> x.getPrecioTotal()).sum();
        System.out.println("Total de ventas: " + totalVentas);

        //Promedio de todas las ventas
        double promedioVentas = repositorioLocalizador.getLocalizadores().stream().mapToDouble(x -> x.getPrecioTotal()).average().getAsDouble();
        System.out.println("Promedio de todas las ventas: " + Math.round(promedioVentas*100)/100.0 );


    }
}
