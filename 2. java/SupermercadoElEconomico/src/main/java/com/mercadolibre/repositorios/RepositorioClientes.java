package com.mercadolibre.repositorios;

import com.mercadolibre.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioClientes implements IRepositorioCRUD<Cliente> {
  private static RepositorioClientes single_instance = null;
  private Map<String, Cliente> clientes;

  public static RepositorioClientes getInstance() {
    if (single_instance == null)
      single_instance = new RepositorioClientes();
    return single_instance;
  }

  private RepositorioClientes() {
    this.clientes = new HashMap<>();
  }

  public void eliminarCliente(String dni) {
    this.clientes.remove(dni);
  }

  public Cliente buscarCliente(String dni) {
    return this.clientes.get(dni);
  }

  public boolean existeCliente(String dni) {
    return this.clientes.containsKey(dni);
  }

  @Override
  public void imprimirRepositorio() {
    clientes.values().stream().forEach(System.out::println);
  }

  @Override
  public boolean agregarItem(Cliente cliente) {
    if (!existeCliente(cliente.getDni())) {
      this.clientes.put(cliente.getDni(), cliente);
      return true;
    }
    return false;
  }

  @Override
  public List<Cliente> obtenerTodos() {
    return new ArrayList<>(
      this.clientes.values()
    );
  }
}
