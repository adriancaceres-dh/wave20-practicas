import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Pepe");
        List<Reserva> reservas = new ArrayList<Reserva>();
        reservas.add(cliente.HacerReserva(1, "Viaje"));
        reservas.add(cliente.HacerReserva(2, "Cena"));
        reservas.add(cliente.HacerReserva(3, "Comida"));

        Localizador localizador = new Localizador(reservas, 1);
        List<Reserva> listaDeReservas = localizador.getReservas();

        listaDeReservas.stream().forEach(r -> System.out.println("Reserva -> "+ r.getId() + " : " + r.getTipo()));

    }
}