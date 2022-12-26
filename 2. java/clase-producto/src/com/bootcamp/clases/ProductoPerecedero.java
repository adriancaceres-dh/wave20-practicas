package com.bootcamp.clases;

public class ProductoPerecedero extends Producto{

    private int diasPorCaducar;

    public ProductoPerecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    // Getters and Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    /*
    Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.

     */

    @Override
    public double calcular(int cantidadDeProductos) {

        double precio = getPrecio();

        if (diasPorCaducar == 1)  {
            setPrecio(precio / 4);
        } else if (diasPorCaducar == 2)  {
            setPrecio(precio / 3);
        } else if (diasPorCaducar == 3)  {
            setPrecio(precio / 2);
        }
        return cantidadDeProductos * (getPrecio());
    }
    

    @Override
    public String toString() {
        return super.toString() +
                "ProductoPerecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

}
