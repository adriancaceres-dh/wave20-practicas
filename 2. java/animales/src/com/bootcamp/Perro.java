package com.bootcamp;

public class Perro extends Animal implements ICarnivoro{
    String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public Perro(String tipo, String nombre) {
        super(tipo);
        this.nombre = nombre;

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", se alimenta: " + comerCarne() +
                '}';
    }

    @Override
    public String emitirSonido(){
        System.out.println(" El perro " + nombre + " hace guau.");
        return "Guau!!!!";
    }

    @Override
    public String comerCarne() {
        System.out.println("Come carne");
        return "El perro come carne!!!!!!";
    }

}
