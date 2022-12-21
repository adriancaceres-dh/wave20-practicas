public class Item {
    private String codigo;
    private String nombre;
    private int cantidad;
    private float costo_unitario;

    public Item(String codigo, String nombre, int cantidad, float costo_unitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }
}
