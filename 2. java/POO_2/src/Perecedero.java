public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        if(diasPorCaducar==1){
            
        }
        return super.calcular(cantidadDeProductos) ;
    }
}
