package org.example;

public class Perecedero extends Producto {

  private int diasCaducidad;

  public Perecedero(String nombre, double precio, int diasCaducidad) {
    super(nombre, precio);
    this.diasCaducidad = diasCaducidad;
  }

  public int getDiasCaducidad() {
    return diasCaducidad;
  }

  public void setDiasCaducidad(int diasCaducidad) {
    this.diasCaducidad = diasCaducidad;
  }

  @Override
  public double calcular(int cantidad) {
    double precioFinal = super.calcular(cantidad);
    if (diasCaducidad == 3) {
      precioFinal *= 0.5;
    } else if (diasCaducidad == 2) {
      precioFinal *= 0.33;
    } else if (diasCaducidad == 1) {
      precioFinal *= 0.25;
    }
    return precioFinal;
  }

  @Override
  public String toString() {
    return "Perecedero{" +
            "diasCaducidad=" + diasCaducidad +
            '}';
  }
}
