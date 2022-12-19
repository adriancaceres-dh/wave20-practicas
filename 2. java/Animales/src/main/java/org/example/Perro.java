package org.example;

public class Perro extends Animal implements Carnivoro {
  public void emitirSonido() {
    System.out.println("Guau!");
  }

  @Override
  public void comerCarne() {
    System.out.println("El perro come carne");
  }

}
