package com.mercadolibre.repositorios;

import com.mercadolibre.model.Factura;

import java.util.ArrayList;
import java.util.List;

public class RepositorioFacturas implements IRepositorioCRUD<Factura> {

  private static RepositorioFacturas single_instance = null;
  private List<Factura> facturas;

  public static RepositorioFacturas getInstance() {
    if (single_instance == null)
      single_instance = new RepositorioFacturas();
    return single_instance;
  }

  private RepositorioFacturas() {
    this.facturas = new ArrayList<>();
  }

  public List<Factura> buscarFacturasPorCliente(String dni) {
    List<Factura> facturasCliente = new ArrayList<>();
    for (Factura factura : facturas) {
      if (factura.getCliente().getDni().equals(dni)) {
        facturasCliente.add(factura);
      }
    }
    return facturasCliente;
  }

  @Override
  public void imprimirRepositorio() {
    for (Factura factura : facturas) {
      System.out.println(factura);
    }
  }

  @Override
  public boolean agregarItem(Factura factura) {
    if (RepositorioClientes.getInstance().existeCliente(factura.getCliente().getDni())) {
      this.facturas.add(factura);
      return true;
    }
    return false;
  }

  @Override
  public List<Factura> obtenerTodos() {
    return facturas;
  }
}
