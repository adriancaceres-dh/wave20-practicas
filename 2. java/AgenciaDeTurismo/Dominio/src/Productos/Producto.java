package Productos;

public abstract class Producto {
    protected double PrecioBase;
    protected String Descripcion;

    public Producto(double precio, String descripcion) {
        PrecioBase = precio;
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return PrecioBase;
    }

    public void setPrecioBase(double precio) {
        PrecioBase = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Precio=" + PrecioBase +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
