public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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
                super.toString() +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos) {
        double preciototal = super.calcular(cantidadProductos);
        switch (this.diasPorCaducar) {
            case 1:
                return preciototal / 4;
            case 2:
                return preciototal / 3;
            case 3:
                return preciototal / 2;
            default:
                return preciototal;
        }
    }
}
