package ejercDistribuidora;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public double calcular(int cantidadDeProductos) throws Exception {
        if(cantidadDeProductos < 0){
            throw new Exception("cantidad no corresponde");
        }
            double resultado = precio * cantidadDeProductos;
             System.out.println(resultado);
              return resultado;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
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
}
