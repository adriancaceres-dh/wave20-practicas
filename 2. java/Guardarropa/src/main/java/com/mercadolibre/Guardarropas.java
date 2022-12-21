package com.mercadolibre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropas {
  private Map<Integer, List<Prenda>> prendas;
  private int currentId; // guarda el ultimo id asignado

  public Guardarropas() {
    this.currentId = 0;
    prendas = new HashMap<>();
  }

  public List<Prenda> devolverPrendas(int id) {
    if (prendas.containsKey(id)) {
      List<Prenda> prendasDevueltas = prendas.get(id);
      prendas.remove(id);
      return prendasDevueltas;
    }
    return null;
  }

  public List<Prenda> consultarPrendas(int id) {
    if (prendas.containsKey(id)) {
      return prendas.get(id);
    }
    return null;
  }

  public Integer guardarPrendas(List<Prenda> prendas) {
    currentId++;
    this.prendas.put(currentId, prendas);
    System.out.println("Prendas guardadas con id: " + currentId);
    return currentId;
  }

  public void mostrarPrendas() {
    prendas.forEach((key, value) -> System.out.println(key + ":" + value));
  }


}
