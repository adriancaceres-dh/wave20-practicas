package com.bootcamp;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad) {
        double precioTotal = super.calcular(cantidad);
        if(this.diasPorCaducar == 1) return precioTotal/4;
        if(this.diasPorCaducar == 2) return precioTotal/3;
        if(this.diasPorCaducar == 3) return precioTotal/2;
        return precioTotal;

    }

    @Override
    public String toString() {
        return "Perecedero{" +
                " nombre=" + this.getNombre() +
                " precio=" + this.getPrecio() +
                " diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
