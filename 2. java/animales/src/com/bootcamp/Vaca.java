package com.bootcamp;

public class Vaca extends Animal implements IHerviboro{

    String nombre;

    public Vaca(String nombre) {
        this.nombre = nombre;
    }

    public Vaca(String tipo, String nombre) {
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
        return "Vaca{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", se alimenta: " + comerHierbas() +
                '}';
    }
    @Override
    public String emitirSonido(){
        System.out.println("La vaca " + nombre + " hace muuu.");
        return "Muuuuuu!!!!";
    }
/*
     @Override
    public boolean comerHierba() {
        System.out.println("Come hierba");
        return true;
    }
*/
    @Override
    public String comerHierbas() {
        System.out.println("Come hierba");
        return "La vaca come hierbas!!!";
    }
}
