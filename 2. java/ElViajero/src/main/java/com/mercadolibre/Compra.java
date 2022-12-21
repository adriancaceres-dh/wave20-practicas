package com.mercadolibre;

public abstract class Compra {
  private int costo;

  public Compra(int costo) {
    this.costo = costo;
  }
  public int getCosto() {
    return costo;
  }
  public void setCosto(int costo) {
    this.costo = costo;
  }

}
