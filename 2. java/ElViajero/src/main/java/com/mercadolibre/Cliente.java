package com.mercadolibre;

import java.util.List;

public class Cliente {
  private List<Localizador> localizadoresComprados;

  public void comprar(Localizador localizador) {
    localizadoresComprados.add(localizador);
  }

  public boolean esClienteFrecuente() {
    return localizadoresComprados.size() >= 2;
  }
}
