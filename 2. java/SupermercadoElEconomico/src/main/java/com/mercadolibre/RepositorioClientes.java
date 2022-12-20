package com.mercadolibre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioClientes {
  private Map<String, Cliente> clientes;

  public RepositorioClientes(Map<String, Cliente> clientes) {
    this.clientes = clientes;
  }

  public RepositorioClientes() {
    this.clientes = new HashMap<>();
  }

  public Map<String, Cliente> getClientes() {
    return clientes;
  }

  public void setClientes(Map<String, Cliente> clientes) {
    this.clientes = clientes;
  }

  public void agregarCliente(Cliente cliente) {
    this.clientes.put(cliente.getDni(), cliente);
  }

  public void eliminarCliente(String dni) {
    this.clientes.remove(dni);
  }

  public Cliente buscarCliente(String dni) {
    return this.clientes.get(dni);
  }
}
