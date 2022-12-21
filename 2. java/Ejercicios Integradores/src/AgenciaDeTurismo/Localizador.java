package AgenciaDeTurismo;

import java.util.LinkedList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    List<IReserva> reservas;

    public Localizador(Cliente cliente, double total) {
        this.cliente = cliente;
        this.total = total;
        reservas = new LinkedList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<IReserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(IReserva nuevaReserva) {
        reservas.add(nuevaReserva);
    }
}
