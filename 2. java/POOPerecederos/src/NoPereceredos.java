public class NoPereceredos extends Producto {
    String tipo;

    public NoPereceredos(){

    }

    public NoPereceredos(String nombre, double precio, String tipo){
        super(nombre,precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
