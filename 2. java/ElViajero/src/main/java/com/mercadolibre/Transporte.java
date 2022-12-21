package com.mercadolibre;

import java.lang.annotation.Target;

public class Transporte extends Compra {

    public Transporte(int costo) {
      super(costo);
    }

  @Override
  public String toString() {
    return "Transporte{}";
  }
}
