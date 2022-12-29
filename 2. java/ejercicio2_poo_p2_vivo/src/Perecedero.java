public class Perecedero extends Producto{

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
    public double calcular(int cantidadDeProductos){

        double total = super.calcular(cantidadDeProductos);
        if (diasPorCaducar <= 1) {
            total = total/4;
        } else if (diasPorCaducar <=2) {
            total = total/3;
        } else if (diasPorCaducar <=3) {
            total = total/2;
        }
        return total;

    }

    @Override
    public String toString() {
        return "Perecedero: " +
                "diasPorCaducar=" + diasPorCaducar;
    }


}
