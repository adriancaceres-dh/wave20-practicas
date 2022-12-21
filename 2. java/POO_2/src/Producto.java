public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos * this.precio;
    }
}
