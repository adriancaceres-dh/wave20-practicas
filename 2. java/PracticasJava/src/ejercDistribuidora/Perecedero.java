package ejercDistribuidora;

public class Perecedero extends Producto {
    private int diasPorCaducar;
    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) throws Exception {
      double resultado = super.calcular(cantidadDeProductos);
        if(diasPorCaducar == 1){
           double precioFinal = resultado / 4;
            System.out.println(precioFinal);
            return precioFinal;
        } else if (diasPorCaducar == 2) {
            double precioFinal = resultado / 3;
            System.out.println(precioFinal);
            return precioFinal;
        }else if (diasPorCaducar == 3){
            double precioFinal = cantidadDeProductos / 2;
            System.out.println(precioFinal);
            return precioFinal;
        }else {
            return resultado;
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
