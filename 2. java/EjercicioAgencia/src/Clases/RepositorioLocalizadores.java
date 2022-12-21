package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioLocalizadores {
    private List<Localizador> localizadores;

    public RepositorioLocalizadores() {
        this.localizadores = new ArrayList<>();
    }

    public void crearLocalizador(Cliente cliente, double total, Carrito carrito) {
        localizadores.add(new Localizador(cliente,total,carrito.getReservas()));
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public boolean esClienteFrecuente(Cliente cliente) {
        return localizadores.stream().filter(loc -> cliente.equals(loc.getCliente())).collect(Collectors.toList()).size()>=2;
    }

    public int cantidadDeLocalizadores() {
        return localizadores.size();
    }

    public int cantidadDeReservas() {
        return localizadores.stream().mapToInt(l -> l.getReservas().size()).sum();
    }

    public double totalDeVentas() {
        return localizadores.stream().mapToDouble(l -> l.getTotal()).sum();
    }
}
