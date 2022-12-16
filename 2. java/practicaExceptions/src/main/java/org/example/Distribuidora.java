package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
  Producto p1 = new NoPerecedero("Arroz", 60, "Alimento");
  Producto p2 = new NoPerecedero("Coca Cola", 100, "Bebida");
  Producto p3 = new Perecedero("Leche", 40, 3);
  Producto p4 = new Perecedero("Huevos", 150, 2);
  private List<Producto> productos = new ArrayList<>(){{
    add(p1);
    add(p2);
    add(p3);
    add(p4);
  }};

  public void imprimirProductos() {
    double precioTotal = 0;
    for (Producto producto : productos) {
      precioTotal += producto.calcular(5);
    }
    System.out.println("El precio total es: " + precioTotal);
  }


}
