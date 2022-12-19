package model;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){

        switch (diasPorCaducar){
            case 1: return (cantidadDeProductos * precio) / 4;
            case 2: return (cantidadDeProductos * precio) / 3;
            case 3: return (cantidadDeProductos * precio) / 2;
            default: return cantidadDeProductos * precio;
        }
    }
}
