package supermercado;

public class Item {
    private long id;
    private int cantidadComprada;
    private Producto producto;

    public Item(int cantidadComprada, Producto producto) {
        this.cantidadComprada = cantidadComprada;
        this.producto = producto;
    }

    public double calcularCosto() {
        return cantidadComprada * producto.getCostoUnitario();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Item{" +
                "cantidadComprada=" + cantidadComprada +
                ", producto=" + producto +
                '}';
    }
}
