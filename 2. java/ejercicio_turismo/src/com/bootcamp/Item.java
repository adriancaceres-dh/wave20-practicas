package com.bootcamp;

public class Item
{
    private Tipo tipo;
    private double precio;

    public Item(Tipo tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void aplicarDescuento(){
        System.out.println("Aplicando descuento..");
        System.out.println("Precio anterior : $"+precio);
        precio = precio - (precio*0.05);
        System.out.println("Nuevo precio : $"+precio);



    }
    @Override
    public String toString() {
        return "Item{" +
                "tipo=" + tipo +
                "precio=" + precio +

                '}';
    }
}
