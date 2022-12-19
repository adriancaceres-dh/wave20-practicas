package com.bootcamp;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
        super(nombre,precio);
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
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if(this.diasPorCaducar==1) return (super.precio*cantidadDeProductos)/4;
        else if (this.diasPorCaducar==2) return (super.precio*cantidadDeProductos)/3;
        else if (this.diasPorCaducar==3) return (super.precio*cantidadDeProductos)/2;

        return 0.0;

        }

    }


