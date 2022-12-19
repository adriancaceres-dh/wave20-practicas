package modelo;

public class Perecedero extends Producto{

    private int diasPorCalcular;

    public Perecedero(int diasPorCalcular, String nombre, double precio ) {
        super(nombre,precio);
        this.diasPorCalcular = diasPorCalcular;
    }

    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    public void setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCalcular=" + diasPorCalcular +
                "} " + super.toString();
    }


    @Override
    public double calcular(int cantidadDeProductos) {
        switch (this.diasPorCalcular) {
            case 1:
                return super.calcular(cantidadDeProductos)/4;
            case 2:
                return super.calcular(cantidadDeProductos)/3;
            default:
                return super.calcular(cantidadDeProductos)/2;
        }
    }

}
