public class Item {
    private String codigo, nombre;
    private double costo;

    public Item(String codigo, String nombre, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }
}
