package objetos;

public class NoPrecedero extends Producto {
    private String tipo;
    public NoPrecedero(String nombre, double precio,String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    @Override
    public String toString(){
        return "Nombre" + this.getNombre() + "- Precio" + this.getPrecio() + "- Tipo " + this.tipo;
    }

//No se necesita sobreescribir el metodo calcular ya que hacen lo mismo
}
