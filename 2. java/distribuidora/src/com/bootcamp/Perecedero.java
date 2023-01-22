package com.bootcamp;

public class Perecedero extends Producto{
    int diasPorCaducar;
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
    @Override
    public  double calcular(int cantidadDeProductos){
      double precio =  super.calcular(cantidadDeProductos);


        double precioFinal = 0;
        switch (diasPorCaducar) {
            case 1:
                precioFinal = precio  / 4;
            break;
            case 2:
                precioFinal = precio / 3;
                break;
            case 3:
                precioFinal = precio / 2;
                break;
            default:
                precioFinal = precio ;
                break;
        }
        return Math.round(precioFinal) ;
    }
}
