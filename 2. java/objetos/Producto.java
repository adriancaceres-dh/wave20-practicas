package objetos;

public class Producto {
    private String nombre;
    private double precio;

    Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){
        return this.precio;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String toString() {
        return "Nombre:" + this.nombre + "- Precio:" + this.precio;
    }

    public double calcular(int cantidadDeProductos){
        return this.precio*cantidadDeProductos;
    }
}
