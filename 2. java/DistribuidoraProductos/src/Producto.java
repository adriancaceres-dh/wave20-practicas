public class Producto {

    protected String nombre;
    protected double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre=" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double calcular(int cantidadDeProductos) {
        double retorno = 0;

        retorno = precio*cantidadDeProductos;

        return retorno;
    }
}
