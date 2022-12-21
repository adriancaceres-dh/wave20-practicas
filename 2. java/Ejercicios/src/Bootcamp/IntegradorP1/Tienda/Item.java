package Bootcamp.IntegradorP1.Tienda;

public class Item{

    private Integer codigo;
    private String nombre;
    private int cantidad;
    private double costo_unitario;

    public Item(Integer codigo, String nombre, int cantidad, double costo_unitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unitario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costo_unitario=" + costo_unitario +
                '}';
    }
}
