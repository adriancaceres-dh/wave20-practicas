public class Perecedero extends Producto {

    public int diasPorCaducar;
    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double calculo = this.precio * cantidadDeProductos;
        switch (this.diasPorCaducar) {
            case 1:
                return calculo / 4;
            case 2:
                return calculo / 3;
            case 3:
                return calculo / 2;
            default:
                return calculo;
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
