package com.mercadolibre.repositorios;

import java.util.List;

public interface IRepositorioCRUD <T> {
  public void imprimirRepositorio();
  public boolean agregarItem(T item);
  public List<T> obtenerTodos();

}
