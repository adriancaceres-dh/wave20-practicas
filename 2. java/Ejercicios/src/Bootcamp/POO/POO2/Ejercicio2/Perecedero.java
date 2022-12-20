package Bootcamp.POO.POO2.Ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
        return super.toString() + "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double Calcular(int cantidadDeProductos){
        double resultado;
        if(diasPorCaducar ==1){
            resultado = super.Calcular(cantidadDeProductos)/4;
        }else if(diasPorCaducar ==2){
            resultado = super.Calcular(cantidadDeProductos)/3;
        }else if(diasPorCaducar ==3){
            resultado = super.Calcular(cantidadDeProductos)/2;
        }else{
            resultado = super.Calcular(cantidadDeProductos);
        }
        return resultado;
    }
}
