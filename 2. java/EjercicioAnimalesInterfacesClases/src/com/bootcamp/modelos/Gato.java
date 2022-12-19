package com.bootcamp.modelos;

public class Gato extends Animal implements ICarnivoros {

    private String raza;
    public Gato(String nombre, int edad, String raza) {
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
        return "Miau!";
    }
    @Override
    public String comerCarne() {
        return "Soy un Gato y estoy comiendo carne";
    }
}
