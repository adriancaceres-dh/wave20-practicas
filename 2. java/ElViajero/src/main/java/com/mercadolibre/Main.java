package com.mercadolibre;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    RepositorioClientes repositorioClientes = new RepositorioClientes();
    RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();

    Cliente cliente = new Cliente("12345678");
    repositorioClientes.agregarCliente(cliente);

    Compra compraBoleto = new BoletoViaje(1000);
    Compra compraComida = new Comida(500);
    Compra compraTransporte = new Transporte(200);
    Compra compraReserva = new Reserva(2000);
    Localizador localizadorPaquete = new Localizador(cliente, List.of(compraBoleto, compraComida, compraTransporte, compraReserva));

    repositorioLocalizadores.agregarLocalizador(localizadorPaquete);
    cliente.agregarLocalizador(localizadorPaquete);

    System.out.println(cliente);
  }
}