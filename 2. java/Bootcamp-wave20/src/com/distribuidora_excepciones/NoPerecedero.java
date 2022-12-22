package com.distribuidora_excepciones;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
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
        String data = "Nombre= " + getNombre() +
                "Precio= " + getPrecio();
        return "NoPerecedero{" + data +
                "tipo='" + tipo + '\'' +
                '}';
    }


}
