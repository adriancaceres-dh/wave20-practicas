package org.example;

public class Vaca extends Animal implements Herbivoro {
  public void emitirSonido() {
    System.out.println("Muuuuuu");
  }

  public void comerHierba() {
    System.out.println("La vaca come hierba");
  }
}
