package com.mercadolibre;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
  private List<Localizador> localizadores;

  public RepositorioLocalizadores() {
    localizadores = new ArrayList<>();
  }

  public void agregarLocalizador(Localizador localizador) {
    localizadores.add(localizador);
  }
}
