package org.example;


import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {  
    System.out.println("Hello world!");
    Main m = new Main();
    m.asignarValor();
  }

  List<String> mensajeStrings = new LinkedList<>();
  //Mensaje final
  String mensajeFinal = "Este es el último mensaje";

  int[] numeros = new int[5];

  public void asignarValor() {
    try {
      numeros[5] = 10;
    }
    catch (ArrayIndexOutOfBoundsException exception) {
      imprimirMensaje(exception.getMessage());

    }
    finally {
      imprimirMensaje(mensajeFinal);
    }

  }

  private void imprimirMensaje(String mensaje) {
    mensajeStrings.add(mensaje);
    System.out.println(mensaje);
  }

}