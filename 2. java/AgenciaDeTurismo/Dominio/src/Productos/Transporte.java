package Productos;
public class Transporte extends Producto {
    public Transporte(double precio, String descripcion) {
        super(precio,descripcion);
    }
    @Override
    public String toString() {
        return "Transporte{}";
    }
}
