package ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
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
    public void calcular(int cantidadDeProductos) throws Exception {
        if(cantidadDeProductos < 0) {
            throw new Exception("La cantidad de productos no puee ser negativa");
        }
        int cantidad_a_dividir = 0;
        if(diasPorCaducar == 1) {
            cantidad_a_dividir = 4;
        }
        else if(cantidad_a_dividir == 2) {
            cantidad_a_dividir = 3;
        }else if(cantidad_a_dividir == 3){
            cantidad_a_dividir = 2;
        }else {
            cantidad_a_dividir = 1;
        }



        System.out.println
                ((super.getPrecio() * cantidadDeProductos)
                        / (cantidad_a_dividir));

        }
    }

