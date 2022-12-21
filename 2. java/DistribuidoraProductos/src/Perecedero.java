public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(double precio, String nombre, int diasPorCaducar) {
        super(precio, nombre);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double retorno=0;
        double precioTotal=0;

        precioTotal = precio*cantidadDeProductos;

        switch(diasPorCaducar) {
            case 1:
                retorno = precioTotal/4;
                break;
            case 2:
                retorno = precioTotal/3;
                break;
            case 3:
                retorno = precioTotal/2;
                break;
            default:
                System.out.println("Error");
                break;
        }
        return retorno;
    }
}
