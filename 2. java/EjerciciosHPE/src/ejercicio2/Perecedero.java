package ejercicio2;

public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(int diasPorCaducar,String nombre, double precio) {
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
    public double calcular(int cantidad){
        double precioTotal = super.calcular(cantidad);
        switch (diasPorCaducar){
            case 1:
                return precioTotal/4;
            case 2:
                return precioTotal/3;
            case 3:
                return precioTotal/2;
            default:
                return precioTotal;
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
