package com.bootcamp.Entidad;

public class Perecederos extends Producto {
    private int diasPorCaducar;

    public Perecederos(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecederos(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecederos{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
    @Override
    public double calcular(int cant){
        double costo = cant * getPrecio();
        switch(diasPorCaducar){
            case 1:
                costo = costo/4;
            case 2:
                costo = costo/3;
            case 3 :
                costo = costo/2;
        }
        return costo;
    }
}
