package agencia;

import agencia.descuento.Descuento;
import repositorio.RepositorioDescuentos;
import agencia.reserva.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private List<Descuento> descuentos;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        descuentos = new ArrayList<>();
        actualizarDescuentos();
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        descuentos = new ArrayList<>();
        actualizarDescuentos();
    }

    private void actualizarDescuentos() {
        for (Descuento descuento : RepositorioDescuentos.listDescuentosVigentes()) {
            if (descuento.aplicaDescuento(this))
                descuentos.add(descuento);
        }
    }

    public double costoTotal() {
        double total = reservas.stream()
                .mapToDouble(Reserva::getCosto)
                .sum();
        double totalConDescuentos = total;
        for (Descuento descuento : descuentos) {
            totalConDescuentos -= descuento.calcularDescuento(this, total);
        }

        return totalConDescuentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        actualizarDescuentos();
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
        actualizarDescuentos();
    }
}
