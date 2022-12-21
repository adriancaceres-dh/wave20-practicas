package com.mercadolibre;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
  private String id;
  private List<Localizador> localizadoresComprados;

  public Cliente(String id) {
    this.id = id;
    localizadoresComprados = new ArrayList<>();
  }

  public void agregarLocalizador(Localizador localizador) {
    localizadoresComprados.add(localizador);
  }

  public boolean esClienteFrecuente() {
    return localizadoresComprados.size() >= 2;
  }

  @Override
  public String toString() {
    return "Cliente{" +
            "id='" + id + '\'' +
            ", localizadoresComprados=" + localizadoresComprados +
            '}';
  }

  public String getId() {
    return id;
  }
}
