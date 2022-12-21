public class Producto {
    String nombre;
    double precio;
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(int precio){
        this.precio= precio;
    }
    public Producto(String nombre, int precio){
        this.nombre = this.nombre;
        this.precio = this.precio;
    }
    public String toString(){
        return "El nombre del producto es: " + this.nombre + "y " + "su precio es: " + this.precio;
    }
    public double calcular(int cantidadDeProductos){
        double resultado = cantidadDeProductos*precio;
        return resultado;
    }
}
