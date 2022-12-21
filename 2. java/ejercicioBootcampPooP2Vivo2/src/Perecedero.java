public class Perecedero extends Producto{
    private int diasPorCaducar;
    public void setDiasPorCaducar(int diasPorCaducar){
        this.diasPorCaducar = diasPorCaducar;
    }
    public int getDiasPorCaducar(){
        return (int) diasPorCaducar;
    }
    public Perecedero( String nombre, int precio, int diasPorCaducar){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    public String toString(){
        return "Los días que tiene este producto para caducar es: " + this.diasPorCaducar;
    }
    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = cantidadDeProductos*this.precio;
        if (diasPorCaducar == 1){
            resultado = resultado/4;
            if (diasPorCaducar ==2){
                resultado = resultado/3;
                if (diasPorCaducar == 3){
                    resultado = resultado/2;
                }else {
                    System.out.println("No aplica para descuento.");
                }
            }
        }
        return resultado;
    }
}
