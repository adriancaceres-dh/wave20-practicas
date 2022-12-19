package objetos;

public class  Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar(){
        return this.diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar){
        this.diasPorCaducar = diasPorCaducar;
    }
    @Override
    public double calcular(int cantidadDeProductos){
        double precioFinal = super.calcular(cantidadDeProductos);//No es necesario que lleme a la clase padre (creo)
        if(this.diasPorCaducar == 1){
            precioFinal = precioFinal/4;
        }
        if(this.diasPorCaducar == 2){
            precioFinal = precioFinal/3;
        }
        if(this.diasPorCaducar == 3){
            precioFinal = precioFinal/2;
        }
        return precioFinal;
    }

    @Override
    public String toString(){
        //aca llama al super para el tostring
        return "Nombre" + this.getNombre() + "- Precio" + this.getPrecio() + "- Dias por caducar " + this.diasPorCaducar;
    }

}
