package com.bootcamp;

public class NoPerecedero extends Producto{

    String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String salida = "No com.bootcamp.Perecedero\n";
        salida += super.toString();
        salida += "Tipo producto: " + this.tipo + "\n";
        return salida;
    }
}
