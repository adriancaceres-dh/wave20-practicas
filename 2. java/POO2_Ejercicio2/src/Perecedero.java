public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero() {
    }

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
    public double calcular(int cantidadDeProductos) {
        double total = this.precio*cantidadDeProductos;
        if(this.diasPorCaducar == 1) total = total/4;
        else if(this.diasPorCaducar == 2) total = total/3;
        else if(this.diasPorCaducar == 3) total = total/2;

        return total;
    }
}
