package com.bootcamp;

public abstract class Animal {
    String tipo;

    public Animal() {
    }

    public Animal(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public String emitirSonido(){
        return "";
    }


}
