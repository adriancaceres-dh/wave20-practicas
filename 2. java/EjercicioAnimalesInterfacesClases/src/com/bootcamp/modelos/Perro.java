package com.bootcamp.modelos;

public class Perro extends Animal implements ICarnivoros{

    private String raza;
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String emitirSonido() {
        return "Guau!";
    }

    @Override
    public String comerCarne() {
        return "Soy un Perro y estoy comiendo carne";
    }
}
