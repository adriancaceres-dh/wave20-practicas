package com.mercadolibre;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Guardarropas guardarropas = new Guardarropas();
    int id = guardarropas.guardarPrendas(List.of(new Prenda("Nike", "Air Max")));
    System.out.println("Prendas guardadas con id: " + id);
    guardarropas.mostrarPrendas();
    List<Prenda> prendas = guardarropas.devolverPrendas(id);
    System.out.println("Prendas devueltas: " + prendas);
  }
}