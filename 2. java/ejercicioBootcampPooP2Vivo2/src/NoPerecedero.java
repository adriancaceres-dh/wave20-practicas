public class NoPerecedero extends Producto{
    String tipo;
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public NoPerecedero(String nombre, int precio, String tipo){
        super(nombre, precio);
        this.tipo = tipo;
    }
    public String toString(){
        return "Este producto no es perecedero ya que su tipo es: " + this.tipo;
    }
    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = cantidadDeProductos*this.precio;
        return resultado;
    }
}

