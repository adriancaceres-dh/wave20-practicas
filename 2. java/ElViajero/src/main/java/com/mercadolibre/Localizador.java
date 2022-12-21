package com.mercadolibre;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
  private Cliente cliente;
  private List<Compra> reservas;
  private int costoTotal;

  public Localizador(Cliente cliente) {
    this.cliente = cliente;
    this.reservas = new ArrayList<Compra>();
    this.costoTotal = 0;
  }

  public Localizador(Cliente cliente, List<Compra> reservas) {
    this.cliente = cliente;
    this.reservas = reservas;
    this.costoTotal = calcularCosto();
  }

  public boolean descuentoPaquete() {
    //TODO: implementar DESCUENTOS
    boolean comproReserva = false;
    boolean comproTransporte = false;
    boolean comproPasaje = false;
    boolean comproComida = false;
    for (Compra reserva : reservas) {
      if (reserva instanceof Reserva) {
        comproReserva = true;
      }
      if (reserva instanceof Transporte) {
        comproTransporte = true;
      }
      if (reserva instanceof BoletoViaje) {
        comproPasaje = true;
      }
      if (reserva instanceof Comida) {
        comproComida = true;
      }
    }
    return comproComida && comproPasaje && comproReserva && comproTransporte;
  }

  public boolean descuentoClienteFrecuente() {
    return cliente.esClienteFrecuente();
  }


  public boolean descuentoDobleReserva() {
    int cantidadReservas = 0;
    for (Compra reserva : reservas) {
      if (reserva instanceof Reserva) {
        cantidadReservas++;
      }
    }
    return cantidadReservas >= 2;
  }

  public boolean descuentoDobleBoleto() {
    int cantidadBoletos = 0;
    for (Compra reserva : reservas) {
      if (reserva instanceof BoletoViaje) {
        cantidadBoletos++;
      }
    }
    return cantidadBoletos >= 2;
  }

  public int calcularCosto() {

    if (descuentoDobleReserva()) {
      for (Compra reserva : reservas) {
        if (reserva instanceof Reserva) {
          reserva.setCosto((int) (reserva.getCosto() * 0.95));
        }
      }
    }
    if (descuentoDobleBoleto()) {
      for (Compra reserva : reservas) {
        if (reserva instanceof BoletoViaje) {
          reserva.setCosto((int) (reserva.getCosto() * 0.95));
        }
      }
    }
    int costo = 0;
    for (Compra reserva : reservas) {
      costo += reserva.getCosto();
    }
    if (descuentoPaquete()) {
      costo *= 0.9;
    }
    if (descuentoClienteFrecuente()) {
      costo *= 0.95;
    }
    return costo;
  }

  public void agregarReserva(Compra reserva) {
    this.reservas.add(reserva);
    this.costoTotal += reserva.getCosto();
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public List<Compra> getReservas() {
    return this.reservas;
  }

  @Override
  public String toString() {
    return "Localizador{" +
            "costoTotal=" + costoTotal +
            '}';
  }
}
