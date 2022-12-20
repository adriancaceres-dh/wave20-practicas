package ejercicio_2;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProducots) {

        double precio = super.calcular(cantidadDeProducots);

        if(diasPorCaducar == 1) return precio/4;
        if(diasPorCaducar == 2) return precio/3;
        if(diasPorCaducar == 3) return precio/2;

        return precio;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "ejercicio_2.Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
