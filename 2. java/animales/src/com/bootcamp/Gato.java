package com.bootcamp;

public class Gato extends  Animal implements  ICarnivoro{
    String  nombre;

    public Gato(String nombre) {
        this.nombre = nombre;
    }

    public Gato(String tipo, String nombre) {
        super(tipo);
        this.nombre = nombre;
        comerCarne();

    }

      public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre + '\'' +
                ", se alimenta: " + comerCarne() +
                '}';
    }
    @Override
    public String emitirSonido(){
        System.out.println("El gato " + nombre + " hace miau.");
        return "Miauuuu!!!!";
    }

    @Override
    public String  comerCarne() {
        System.out.println("Come carne");
        return "El gato come carne!!!!";
    }
}
