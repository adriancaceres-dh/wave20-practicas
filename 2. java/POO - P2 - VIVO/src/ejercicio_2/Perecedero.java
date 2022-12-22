package ejercicio_2;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString(){
        return ("Nombre: " + this.getNombre() + ".\nPrecio: $" + this.getPrecio() + ".\nVence en " + this.getDiasPorCaducar() + " días.\n");
    }

    public double calcular (int cantidadDeProductos) {
        // return (this.getPrecio() * cantidadDeProductos);
        double retorno=0;
        if (this.diasPorCaducar==3) {
            retorno=((this.getPrecio() * cantidadDeProductos)/2);
        } else if (this.diasPorCaducar==2) {
            retorno=((this.getPrecio() * cantidadDeProductos)/3);
        } else if (this.diasPorCaducar==1) {
            retorno=((this.getPrecio() * cantidadDeProductos)/4);
        }

        return retorno;
    }

}
