package ejercicio2;

public class Producto
{
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

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

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public void calcular(int cantidadDeProductos) throws Exception {
        if(cantidadDeProductos < 0){
            throw new Exception("La cantidad no puede ser negativa");
        }

        System.out.println(precio * cantidadDeProductos);
    }


}
