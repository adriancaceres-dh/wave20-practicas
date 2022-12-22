package com.bootcamp;

import com.bootcamp.productos.BoletoViaje;
import com.bootcamp.productos.ReservaHotel;

import java.util.List;

public class Agencia {

    private RepositorioClientes repoClientes;
    private RepositorioLocalizador repoLocalizador;

    public Agencia() {
        repoClientes = new RepositorioClientes();
        repoLocalizador = new RepositorioLocalizador();
    }

    public RepositorioClientes getRepoClientes() {
        return repoClientes;
    }

    public void setRepoClientes(RepositorioClientes repoClientes) {
        this.repoClientes = repoClientes;
    }

    public RepositorioLocalizador getRepoLocalizador() {
        return repoLocalizador;
    }

    public void setRepoLocalizador(RepositorioLocalizador repoLocalizador) {
        this.repoLocalizador = repoLocalizador;
    }
    public int verificarReservasAnteriores(Cliente cliente) {
        if(repoClientes.getRepositorio().contains(cliente))
        return (int) repoLocalizador.getRepositorio()
                .stream()
                .filter(l -> l.getCliente().getId().equals(cliente.getId()))
                .count();
        else return 0;
    }

    public boolean ingresarCliente(Cliente cliente) {
        if(!repoClientes.getRepositorio().contains(cliente)) {
            repoClientes.getRepositorio().add(cliente);
            return true;
        } else {
            return false;
        }
    }

    /** El calculo del costo total de la compra se ve condicionado por los siguientes descuentos:
     * -Si un cliente anteriormente adquirió al menos 2 localizadores,
     * se le descontará un 5% del total para futuras compras.
     * -Si un cliente adquiere un paquete completo que consiste en reserva de hotel,
     * comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
     * -Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje,
     * se aplicará un descuento de 5% en esas reservas.
     *
     * @param loc
     * @return el total de la compra segun apliquen descuentos
     */
    public double calcularTotalCompra(Localizador loc) {
        double subTotal = loc.getReserva().stream().mapToDouble(i -> i.getPrecio()).sum();
        if(verificarReservasAnteriores(loc.getCliente()) >= 2) {
            subTotal = subTotal * 0.95;
        }
        if(verificarPaqueteCompleto(loc)) {
            subTotal = subTotal * 0.9;
        }
        if(verificarReservasHotelYBoletos(loc)) {
            double sumaBoletoHotel = loc.getReserva()
                    .stream()
                    .filter(i -> i instanceof BoletoViaje || i instanceof ReservaHotel)
                    .mapToDouble(i -> i.getPrecio())
                    .sum();
            subTotal -= sumaBoletoHotel;
            sumaBoletoHotel*=.95;
            subTotal+= sumaBoletoHotel;
        }
        return subTotal;

    }

    /**
     *
     * @param loc
     * @return false si es la primera compra del cliente, true si es un cliente recurrente
     */
    public boolean ingresarLocalizador(Localizador loc) {
        loc.setTotal(calcularTotalCompra(loc));
        repoLocalizador.getRepositorio().add(loc);
        System.out.println(loc);
        return ingresarCliente(loc.getCliente());
    }

    public boolean verificarPaqueteCompleto(Localizador loc) {
        return loc.getReserva()
                .stream()
                .map(i -> i.getClass().toString())
                .distinct()
                .count() == 4;
    }

    public boolean verificarReservasHotelYBoletos(Localizador loc) {
        return loc.getReserva()
                .stream()
                .filter(i -> i instanceof ReservaHotel)
                .count() >= 2
                ||
                loc.getReserva()
                        .stream()
                        .filter(i -> i instanceof BoletoViaje)
                        .count() >=2;
    }
}
