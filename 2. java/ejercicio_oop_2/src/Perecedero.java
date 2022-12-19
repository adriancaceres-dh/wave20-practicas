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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
    @Override
    public double calcular(int cantidadDeProductos) {
        switch (diasPorCaducar){
            case(1):
                return this.getPrecio()*cantidadDeProductos/4;
            case(2):
                return this.getPrecio()*cantidadDeProductos/3;
            case(3):
                return this.getPrecio()*cantidadDeProductos/2;
        }
        return this.getPrecio()*cantidadDeProductos;
    }
}
