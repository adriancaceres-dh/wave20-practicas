package org.example;

public class Gato extends Animal implements Carnivoro {
  public void emitirSonido() {
    System.out.println("Miau");
  }

  public void comerCarne() {
    System.out.println("El gato come carne");
  }

}